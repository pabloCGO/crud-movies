package com.ejemplo.apringboot.app.peliculas.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.apringboot.app.peliculas.config.models.dto.MovieDetail;
import com.ejemplo.apringboot.app.peliculas.service.MovieRestService;

/**
 * 
 * @author PELS
 *
 */
@RestController
public class MovieController {
	
	private static Logger log = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieRestService movieRestService;

	@GetMapping(value= "/movie", produces = "application/json")
	public MovieDetail listar(@RequestParam String title) {
		log.info("buscando movie: {}", title);
		MovieDetail peli = movieRestService.getMovieByTitle(title);
		log.info("peli= " + peli);
		return peli;
	}
}
