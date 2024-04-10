package com.moviely.moviely.repository;

import com.moviely.moviely.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
//Querydsl 안 넣음

