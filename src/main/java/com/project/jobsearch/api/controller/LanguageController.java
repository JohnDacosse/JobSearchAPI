package com.project.jobsearch.api.controller;

import com.project.jobsearch.api.dto.LanguageDTO;
import com.project.jobsearch.api.entity.Language;
import com.project.jobsearch.api.service.LanguageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/languages")
    public List<LanguageDTO> getAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<LanguageDTO> languagesDTO = new ArrayList<>();
        List<Language> languages =  languageService.getAll();

        for (Language language: languages ) {
            LanguageDTO languageDTO = modelMapper.map(language, LanguageDTO.class);
            languagesDTO.add(languageDTO);
        }
        return languagesDTO;
    }

    @GetMapping("/language/{id}")
    public LanguageDTO getById(@PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<Language> language =  languageService.getById(id);
        Language l = language.get();
        LanguageDTO languageDTO =  mapper.map(l, LanguageDTO.class);
        return languageDTO;
    }

}
