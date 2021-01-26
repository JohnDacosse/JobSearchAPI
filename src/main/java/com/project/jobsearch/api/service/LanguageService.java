package com.project.jobsearch.api.service;


import com.project.jobsearch.api.entity.Language;
import com.project.jobsearch.api.repository.ILanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author johnd
 * @version 1.0
 */
@Service
public class LanguageService {

    private final ILanguageRepository languageRepository;

    @Autowired
    public LanguageService(ILanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }


    /**
     * Get all the languages
     * @return List of languages
     */
    public List<Language> getAll() {
        List<Language> languages =  languageRepository.findAll();
        return languages;
    }

    /**
     * Get a language by id
     * @param id
     * @return A language
     */
    public Optional<Language> getById(final Long id) {
        Optional<Language> language = languageRepository.findById(id);
        if (language.isEmpty()) return null;
        return language;
    }
}
