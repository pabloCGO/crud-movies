package com.ejemplo.apringboot.app.peliculas.service;

import java.util.List;

import com.ejemplo.apringboot.app.peliculas.config.models.entity.MovieRating;

public interface MovieService {
	
	MovieRating getMovieRating(Long id);

	List<MovieRating> getAllMovieRating();
			
	void saveOrupdateMovieRating(MovieRating movieRating);
	
	void deleteMovieRating(Long id);

}
