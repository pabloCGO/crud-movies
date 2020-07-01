package com.ejemplo.apringboot.app.peliculas.repository;

import org.springframework.data.repository.CrudRepository;

import com.ejemplo.apringboot.app.peliculas.config.models.entity.MovieRating;

public interface MovieRepository extends CrudRepository<MovieRating, Long>{

}
