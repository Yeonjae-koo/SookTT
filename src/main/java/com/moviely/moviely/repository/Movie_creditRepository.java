package com.moviely.moviely.repository;

import com.moviely.moviely.domain.Movie_credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Movie_creditRepository extends JpaRepository<Movie_credit, Long> {
}