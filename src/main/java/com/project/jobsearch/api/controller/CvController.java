package com.project.jobsearch.api.controller;

import com.project.jobsearch.api.dto.CvDTO;
import com.project.jobsearch.api.dto.UserDTO;
import com.project.jobsearch.api.entity.Cv;
import com.project.jobsearch.api.entity.User;
import com.project.jobsearch.api.service.CvService;
import com.project.jobsearch.api.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CvController {

    private final CvService cvService;
    private final UserService userService;

    @Autowired
    public CvController(CvService cvService, UserService userService) {
        this.cvService = cvService;
        this.userService = userService;
    }

//    @GetMapping("/cvs")
//    public List<CvDTO> getAll() {
//        ModelMapper modelMapper = new ModelMapper();
//        List<CvDTO> cvsDTO = new ArrayList<>();
//        List<Cv> cvs =  cvService.getAll();
//
//        for (Cv cv: cvs ) {
//            CvDTO cvDTO = modelMapper.map(cv, CvDTO.class);
//            cvsDTO.add(cvDTO);
//        }
//        return cvsDTO;
//    }

//    @GetMapping("/cv/{id}")
//    public CvDTO getById(@PathVariable Long id) {
//        ModelMapper mapper = new ModelMapper();
//
//        Optional<Cv> cv =  cvService.getById(id);
//        Cv c = cv.get();
//        CvDTO cvDTO =  mapper.map(c, CvDTO.class);
//        return cvDTO;
//    }

    @PostMapping("/cvs")
    public CvDTO create(@RequestBody CvDTO cv) {
        ModelMapper mapper = new ModelMapper();
//        CvDTO cvDTO = mapper.map(cvService.create(cv), CvDTO.class);
        Optional<User> user = this.userService.getById(cv.getUserId());
        Cv entity = mapper.map(cv, Cv.class);
        return mapper.map(cvService.create(entity, user.get()), CvDTO.class);
    }

    @PutMapping("/cvs/{id}")
    public CvDTO update(@RequestBody Cv cv, @PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();
        CvDTO cvDTO = mapper.map(cvService.update(cv, id), CvDTO.class);
        return cvDTO;
    }

//    @DeleteMapping("cvs/{id}")
//    public void delete(@PathVariable Long id) {
//        cvService.delete(id);
//    }

    @GetMapping("/cv/user/{id}")
    public CvDTO getCvByUserId(@PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();
        CvDTO cvDTO = mapper.map(cvService.getByUserId(id), CvDTO.class);
        return cvDTO;
    }

}
