package com.ejemplo.apringboot.app.dao.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplo.apringboot.app.config.AppConfig;
import com.ejemplo.apringboot.app.peliculas.config.models.entity.MovieRating;
import com.ejemplo.apringboot.app.peliculas.repository.MovieRepository;

@SpringBootTest(classes = AppConfig.class)
@EnableAutoConfiguration
public class MovieRatingTest {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Test
	public void crear() {

		MovieRating movieRating = new MovieRating();
		movieRating.setImdbID("243fd");
		movieRating.setRating(8.9D);
		movieRepository.save(movieRating);
		
		Iterable<MovieRating> totalMovies = movieRepository.findAll();

        int rows = 1;
        assertThat(totalMovies).hasSize(rows);
	}

}
