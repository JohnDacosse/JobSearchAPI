package com.project.jobsearch.api.repository;

import com.project.jobsearch.api.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILevelRepository extends JpaRepository<Level, Long> {
}
