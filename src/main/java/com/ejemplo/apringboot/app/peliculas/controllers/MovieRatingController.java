package com.ejemplo.apringboot.app.peliculas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.apringboot.app.peliculas.config.models.entity.MovieRating;
import com.ejemplo.apringboot.app.peliculas.service.MovieService;

/**
 * 
 * @author PELS
 *
 */
@RestController
public class MovieRatingController {
	
	private static Logger log = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;

	@GetMapping(value= "/movie-rating", produces = "application/json")
	public List<MovieRating> findAll() {
		log.info("buscando todo los ratings de peliculas");
		return movieService.getAllMovieRating();
	}
	
	@GetMapping(value= "/movie-rating/{id}", produces = "application/json")
	public ResponseEntity<?> findById(@PathVariable(required = true) Long id) {
		MovieRating movie = movieService.getMovieRating(id);
		if(null == movie.getId()) {
			Map<String, String> json= new HashMap<>();
			json.put("mensaje", "No se encontró la pelicula");
			return new ResponseEntity<Map<String,String>>(json, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MovieRating>(movie, HttpStatus.OK);
	}
	
	@PostMapping(value= "/movie-rating", produces = "application/json")
	public ResponseEntity<?> save(@RequestBody MovieRating movieRating) {
		Map<String, String> json= new HashMap<>();
		json.put("mensaje", "Registro creado correctamente");
		movieService.saveOrupdateMovieRating(movieRating);
		return new ResponseEntity<Map<String,String>>(json, HttpStatus.CREATED);
	}
	
	@PutMapping(value= "/movie-rating", produces = "application/json")
	public ResponseEntity<?> update(@RequestBody MovieRating movieRating) {
		Map<String, String> json= new HashMap<>();
		
		if(null == movieRating.getId()) {
			json.put("mensaje", "El id no puede ser nulo");
			return new ResponseEntity<Map<String,String>>(json, HttpStatus.BAD_REQUEST);
		}
		
		if(null == movieService.getMovieRating(movieRating.getId()).getId()) {
			json.put("mensaje", "El id que intenta actualizar no existe");
			return new ResponseEntity<Map<String,String>>(json, HttpStatus.NOT_FOUND);
		}
		movieService.saveOrupdateMovieRating(movieRating);
		json.put("mensaje", "Registro actualizado correctamente");
		return new ResponseEntity<Map<String,String>>(json, HttpStatus.OK);
	}
	
	@DeleteMapping(value= "/movie-rating/{id}", produces = "application/json")
	public ResponseEntity<?> delete(@PathVariable(required = true) Long id) {
		Map<String, String> json= new HashMap<>();
		if(null == movieService.getMovieRating(id).getId()) {
			json.put("mensaje", "El id que intenta eliminar no existe");
			return new ResponseEntity<Map<String,String>>(json, HttpStatus.NOT_FOUND);
		}
		movieService.deleteMovieRating(id);
		json.put("mensaje", "Registro eliminado correctamente");
		return new ResponseEntity<Map<String,String>>(json, HttpStatus.OK);
	}
}