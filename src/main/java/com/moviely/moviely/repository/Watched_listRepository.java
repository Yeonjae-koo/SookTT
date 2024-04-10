package com.moviely.moviely.repository;

import com.moviely.moviely.domain.Watched_list;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Watched_listRepository extends JpaRepository<Watched_list, Long> {
}