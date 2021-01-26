package com.project.jobsearch.api.repository;

import com.project.jobsearch.api.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findAllByUserUserId(@Param("userId") Long userId);
}
