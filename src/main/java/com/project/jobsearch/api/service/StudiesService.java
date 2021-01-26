package com.project.jobsearch.api.service;

import com.project.jobsearch.api.entity.Cv;
import com.project.jobsearch.api.entity.Studies;
import com.project.jobsearch.api.entity.User;
import com.project.jobsearch.api.repository.IStudiesRepository;
import com.project.jobsearch.api.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

/**
 * @author johnd
 * @version 1.0
 */
@Service
public class StudiesService {

    private final IStudiesRepository studiesRepository;

    @Autowired
    public StudiesService(IStudiesRepository studiesRepository) {
        this.studiesRepository = studiesRepository;
    }

    /**
     * Create a new studies
     * @param studies
     * @return The created studies
     */
    public Studies create(Studies studies) {
        studiesRepository.save(studies);
        return studies;
    }

    /**
     * Get a studies by id
     * @param id
     * @return A studies
     */
    public Optional<Studies> getById(final Long id) {
        Optional<Studies> studies = studiesRepository.findById(id);
        if (studies.isEmpty()) return null;

        return studies;
    }

    /**
     * Replace rows of an studies
     * @param newStudies
     * @param id
     * @return The updated studies
     */
    public Studies update(Studies newStudies, final Long id) {
        return studiesRepository.findById(id)
                .map(studies -> {
                    studies.setTitle(newStudies.getTitle());
                    studies.setLocation(newStudies.getLocation());
                    studies.setDegree(newStudies.getDegree());
                    studies.setStartDate(newStudies.getStartDate());
                    studies.setEndDate(newStudies.getEndDate());
                    studiesRepository.save(studies);
                    return studies;
                })
                .orElseGet(() -> {
                    newStudies.setStudiesId(id);
                    studiesRepository.save(newStudies);
                    return newStudies;
                });
    }

    /**
     * Delete a studies
     * @param id
     */
    public void delete(final Long id) {
        studiesRepository.deleteById(id);
    }

    /**
     * List of all cv's studies
     * @param id
     * @return
     */
    public List<Studies> getAllByCvId(Long id) {
        List<Studies> studies = studiesRepository.findAllByCvCvId(id);
        return studies;
    }



}
