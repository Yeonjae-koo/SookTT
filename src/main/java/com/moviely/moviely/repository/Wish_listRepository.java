package com.moviely.moviely.repository;

import com.moviely.moviely.domain.Wish_list;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Wish_listRepository extends JpaRepository<Wish_list, Long> {
}