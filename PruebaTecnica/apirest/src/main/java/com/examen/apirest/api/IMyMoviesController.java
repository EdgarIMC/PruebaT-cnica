package com.examen.apirest.api;

import java.util.List;

import com.examen.apirest.dto.Movie;
import com.examen.apirest.dto.MyMovies;

public interface IMyMoviesController {
	
	public String getMovie(String name);
	public List<Movie> getMovies();
	public Movie getMovieById(Long id);	
	public MyMovies addMovie(MyMovies movie);	
	public String deleteMovie(Long id);	
	public String updateMovie(MyMovies updateMovie);	
	}
