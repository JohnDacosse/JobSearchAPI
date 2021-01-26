package com.project.jobsearch.api.service;

import com.project.jobsearch.api.entity.Cv;
import com.project.jobsearch.api.entity.Favorite;
import com.project.jobsearch.api.entity.License;
import com.project.jobsearch.api.entity.User;
import com.project.jobsearch.api.repository.IFavoriteRepository;
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
public class LicenseService {

    private final ILicenseRepository licenseRepository;

    @Autowired
    public LicenseService(ILicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

//    /**
//     * Create a new license
//     * @param license, user
//     * @return The created license
//     */
//    public License create(License license, List<Cv> cvs) {
//        license.setCvs(cvs);
//        licenseRepository.save(license);
//        return license;
//    }
//
    /**
     * Get all the licenses
     * @return List of licenses
     */
    public List<License> getAll() {
        List<License> licenses =  licenseRepository.findAll();
        return licenses;
    }

    /**
     * Get a license by id
     * @param id
     * @return A license
     */
    public Optional<License> getById(final Long id) {
        Optional<License> license = licenseRepository.findById(id);
        if (license.isEmpty()) return null;
        return license;
    }

//    /**
//     * Replace rows of a license
//     * @param newLicense
//     * @param id
//     * @return The updated license
//     */
//    public License update(License newLicense, final Long id) {
//        return licenseRepository.findById(id)
//                .map(license -> {
//                    license.setType(newLicense.getType());
//                    licenseRepository.save(license);
//                    return license;
//                })
//                .orElseGet(() -> {
//                    newLicense.setLicenseId(id);
//                    licenseRepository.save(newLicense);
//                    return newLicense;
//                });
//    }

//    /**
//     * Delete a license
//     * @param id
//     */
//    public void delete(final Long id) {
//        licenseRepository.deleteById(id);
//    }
//
//
//    public License getByUserId(Long id) {
//        License license = licenseRepository.findByCvCvId(id);
//        return license;
//    }
}
