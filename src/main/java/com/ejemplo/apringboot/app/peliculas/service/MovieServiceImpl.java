package com.ejemplo.apringboot.app.peliculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.apringboot.app.peliculas.config.models.entity.MovieRating;
import com.ejemplo.apringboot.app.peliculas.repository.MovieRepository;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public MovieRating getMovieRating(Long id) {
		return movieRepository.findById(id).orElse(new MovieRating());
	}

	@Override
	public List<MovieRating> getAllMovieRating() {
		return (List<MovieRating>) movieRepository.findAll();
	}

	@Override
	public void saveOrupdateMovieRating(MovieRating movieRating) {
		movieRepository.save(movieRating);
	}

	@Override
	public void deleteMovieRating(Long id) {
		movieRepository.deleteById(id);
	}

}
