package com.project.jobsearch.api.controller;

import com.project.jobsearch.api.dto.FavoriteDTO;
import com.project.jobsearch.api.dto.StudiesDTO;
import com.project.jobsearch.api.dto.UserDTO;
import com.project.jobsearch.api.entity.Favorite;
import com.project.jobsearch.api.entity.Studies;
import com.project.jobsearch.api.entity.User;
import com.project.jobsearch.api.service.StudiesService;
import com.project.jobsearch.api.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudiesController {

    private final StudiesService studiesService;

    @Autowired
    public StudiesController(StudiesService studiesService) {
        this.studiesService = studiesService;
    }

    @GetMapping("/studies/{id}")
    public StudiesDTO getById(@PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<Studies> studies =  studiesService.getById(id);
        Studies s = studies.get();
        StudiesDTO studiesDTO =  mapper.map(s, StudiesDTO.class);
        return studiesDTO;
    }

    @PostMapping("/studies")
    public StudiesDTO create(@RequestBody Studies studies) {
        ModelMapper mapper = new ModelMapper();
        StudiesDTO studiesDTO = mapper.map(studiesService.create(studies), StudiesDTO.class);
        return studiesDTO;
    }

    @PutMapping("/studiesp/{id}")
    public StudiesDTO update(@RequestBody Studies studies, @PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();
        StudiesDTO studiesDTO = mapper.map(studiesService.update(studies, id), StudiesDTO.class);
        return studiesDTO;
    }

    @DeleteMapping("/studiesd/{id}")
    public void delete(@PathVariable Long id) {
        studiesService.delete(id);
    }

    @GetMapping("/studiesa")
    public List<StudiesDTO> getStudiesByCvId(@PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();
        List<StudiesDTO> studiesDTO = new ArrayList<>();
        List<Studies> studies = studiesService.getAllByCvId(id);
        StudiesDTO dto = null;

        for (Studies stu : studies) {
            dto = mapper.map(stu, StudiesDTO.class);
            studiesDTO.add(dto);
        }

        return studiesDTO;
    }

}
