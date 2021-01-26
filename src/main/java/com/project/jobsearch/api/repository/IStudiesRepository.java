package com.project.jobsearch.api.repository;

import com.project.jobsearch.api.entity.Studies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudiesRepository extends JpaRepository<Studies, Long> {
    List<Studies> findAllByCvCvId(@Param("cvId") Long cvId);
}
