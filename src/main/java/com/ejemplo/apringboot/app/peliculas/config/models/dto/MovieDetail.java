package com.ejemplo.apringboot.app.peliculas.config.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDetail {
	
	@JsonProperty("imdbID")
	private String imdbID;
	
	@JsonProperty("Title")
	private String title;
	
	@JsonProperty("Year")
	private String year;
	
	@JsonProperty("Director")
	private String director;
	
	@JsonProperty("Plot")
	private String plot;

	@JsonProperty("Response")
	private String response;
	
	@JsonProperty("Error")
	private String error;

	/**
	 * @return the imdbID
	 */
	public String getImdbID() {
		return imdbID;
	}

	/**
	 * @param imdbID the imdbID to set
	 */
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the plot
	 */
	public String getPlot() {
		return plot;
	}

	/**
	 * @param plot the plot to set
	 */
	public void setPlot(String plot) {
		this.plot = plot;
	}

	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "DetallePelicula [imdbID=" + imdbID + ", title=" + title + ", year=" + year + ", director=" + director
				+ ", plot=" + plot + ", response=" + response + ", error=" + error + "]";
	}

	
	
}
