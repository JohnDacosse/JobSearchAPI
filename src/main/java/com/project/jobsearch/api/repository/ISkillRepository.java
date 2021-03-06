package com.project.jobsearch.api.repository;

import com.project.jobsearch.api.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository<Skill, Long> {
}
