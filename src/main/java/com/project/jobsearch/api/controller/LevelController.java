package com.project.jobsearch.api.controller;

import com.project.jobsearch.api.dto.LevelDTO;
import com.project.jobsearch.api.entity.Level;
import com.project.jobsearch.api.service.LevelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class LevelController {

    private final LevelService levelService;

    @Autowired
    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @GetMapping("/levels")
    public List<LevelDTO> getAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<LevelDTO> levelsDTO = new ArrayList<>();
        List<Level> levels =  levelService.getAll();

        for (Level level: levels ) {
            LevelDTO levelDTO = modelMapper.map(level, LevelDTO.class);
            levelsDTO.add(levelDTO);
        }
        return levelsDTO;
    }

    @GetMapping("/level/{id}")
    public LevelDTO getById(@PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<Level> level =  levelService.getById(id);
        Level l = level.get();
        LevelDTO levelDTO =  mapper.map(l, LevelDTO.class);
        return levelDTO;
    }

}
