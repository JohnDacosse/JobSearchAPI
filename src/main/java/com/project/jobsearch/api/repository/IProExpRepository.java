package com.project.jobsearch.api.repository;

import com.project.jobsearch.api.entity.ProExp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProExpRepository extends JpaRepository<ProExp, Long> {
}
