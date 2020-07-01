package com.ejemplo.apringboot.app.peliculas.service;

import com.ejemplo.apringboot.app.peliculas.config.models.dto.MovieDetail;

public interface MovieRestService {
	
	MovieDetail getMovieByTitle(String title);

}
