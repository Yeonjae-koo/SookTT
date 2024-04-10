package com.moviely.moviely.repository;

import com.moviely.moviely.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PeopleRepository extends JpaRepository<People, Long> {
}