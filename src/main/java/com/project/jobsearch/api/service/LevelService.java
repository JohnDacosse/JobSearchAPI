package com.project.jobsearch.api.service;

import com.project.jobsearch.api.entity.Level;
import com.project.jobsearch.api.entity.License;
import com.project.jobsearch.api.repository.ILevelRepository;
import com.project.jobsearch.api.repository.ILicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author johnd
 * @version 1.0
 */
@Service
public class LevelService {

    private final ILevelRepository levelRepository;

    @Autowired
    public LevelService(ILevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    /**
     * Get all the levels
     * @return List of levels
     */
    public List<Level> getAll() {
        List<Level> level =  levelRepository.findAll();
        return level;
    }

    /**
     * Get a level by id
     * @param id
     * @return A level
     */
    public Optional<Level> getById(final Long id) {
        Optional<Level> level = levelRepository.findById(id);
        if (level.isEmpty()) return null;
        return level;
    }
}
