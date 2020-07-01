package com.ejemplo.apringboot.app.peliculas.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ejemplo.apringboot.app.peliculas.config.models.dto.MovieDetail;

@Service("movieRestService")
public class MovieRestServiceImpl implements MovieRestService {

	private static final String API_KEY = "8fd7b4bf";

	@Autowired
	private RestTemplate clienteRest;

	@Override
	public MovieDetail getMovieByTitle(String title) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("title", title);
		params.put("apiKey", API_KEY);

		return clienteRest.getForObject("http://www.omdbapi.com/?t={title}&apiKey={apiKey}", MovieDetail.class,
				params);
	}

}
