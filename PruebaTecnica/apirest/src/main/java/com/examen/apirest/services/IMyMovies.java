package com.examen.apirest.services;

import java.util.List;
import java.util.Optional;
import com.examen.apirest.dto.MyMovies;

public interface IMyMovies {
	
	public List<MyMovies> findAllMovies();	
	public Optional<MyMovies> findMovieById(Long id);	
	public MyMovies saveMovie(MyMovies newMovie);	
	public String deleteMovie(Long id);	
	public String updateMovie(MyMovies newMovie);
}
