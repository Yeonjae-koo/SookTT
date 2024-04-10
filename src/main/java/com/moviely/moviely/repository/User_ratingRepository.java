package com.moviely.moviely.repository;

import com.moviely.moviely.domain.User_rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface User_ratingRepository extends JpaRepository<User_rating, Long> {
}