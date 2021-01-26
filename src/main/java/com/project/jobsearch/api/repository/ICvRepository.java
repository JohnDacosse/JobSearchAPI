package com.project.jobsearch.api.repository;

import com.project.jobsearch.api.entity.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICvRepository extends JpaRepository<Cv, Long> {
//    @Query(value = "SELECT cv FROM Cv cv WHERE cv.user.userId = :userId")
    Cv findByUserUserId(@Param("userId") Long userId);
}
