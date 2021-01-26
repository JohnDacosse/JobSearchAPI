package com.project.jobsearch.api.service;

import com.project.jobsearch.api.entity.Cv;
import com.project.jobsearch.api.entity.User;
import com.project.jobsearch.api.repository.ICvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author johnd
 * @version 1.0
 */
@Service
public class CvService {

    private final ICvRepository cvRepository;

    @Autowired
    public CvService(ICvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    /**
     * Create a new cv
     * @param cv
     * @return The created cv
     */
    public Cv create(Cv cv, User user) {
        cv.setUser(user);
        cvRepository.save(cv);
        return cv;
    }

//    /**
//     * Get all the cvs
//     * @return List of cvs
//     */
//    public List<Cv> getAll() {
//        List<Cv> cvs =  cvRepository.findAll();
//        return cvs;
//    }

//    /**
//     * Get an cv by id
//     * @param id
//     * @return A cv
//     */
//    public Optional<Cv> getById(final Long id) {
//        Optional<Cv> cv = cvRepository.findById(id);
//        if (cv.isEmpty()) return null;
//        return cv;
//    }

    /**
     * Replace rows of an user
     * @param newCv
     * @param id
     * @return The updated user
     */
    public Cv update(Cv newCv, final Long id) {
        return cvRepository.findById(id)
                .map(cv -> {
                    cv.setFirstName(newCv.getFirstName());
                    cv.setLastName(newCv.getLastName());
                    cv.setBirthDate(newCv.getBirthDate());
                    cv.setLanguage(newCv.getLanguages());
                    cv.setLicenses(newCv.getLicenses());
                    cv.setProExps(newCv.getProExps());
                    cv.setSkills(newCv.getSkills());
                    cv.setStudies(newCv.getStudies());
                    cv.setVehicle(newCv.getVehicle());
                    cvRepository.save(cv);
                    return cv;
                })
                .orElseGet(() -> {
                    newCv.setCvId(id);
                    cvRepository.save(newCv);
                    return newCv;
                });
    }

//    /**
//     * Delete an user
//     * @param id
//     */
//    public void delete(final Long id) {
//        cvRepository.deleteById(id);
//    }


    public Cv getByUserId(Long id) {
        Cv cv = cvRepository.findByUserUserId(id);
        return cv;
    }
}
