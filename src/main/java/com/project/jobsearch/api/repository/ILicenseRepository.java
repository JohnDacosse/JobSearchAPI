package com.project.jobsearch.api.repository;

import com.project.jobsearch.api.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ILicenseRepository extends JpaRepository<License, Long> {
//    License findByCvId(@Param("cvId") Long cvId);
}
