package com.examen.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examen.apirest.dao.MyMoviesRepository;
import com.examen.apirest.dto.MyMovies;

@Service
public class MyMovieService implements IMyMovies {
	
	@Autowired
	private MyMoviesRepository repository;

	@Override
	public List<MyMovies> findAllMovies() {
		return repository.findAll();
	}

	@Override
	public Optional<MyMovies> findMovieById(Long id) {
		Optional<MyMovies> movie = repository.findById(id);			
		return movie;
	}

	@Override
	public MyMovies saveMovie(MyMovies newMovie) {
		if (newMovie != null) {				
			return repository.save(newMovie);			
			}			
		return new MyMovies();
	}

	@Override
	public String deleteMovie(Long id) {
		if (repository.findById(id).isPresent()) {				
			repository.deleteById(id);				
			return "Pelicula eliminada correctamente.";			
			}			
		return "La pelicula no existe";
	}

	@Override
	public String updateMovie(MyMovies updateMovie) {
		Long num = updateMovie.getId();
		if (repository.findById(num).isPresent()) {
			MyMovies movieToUpdate = new MyMovies();
			movieToUpdate.setId(movieToUpdate.getId());
			movieToUpdate.setTitle(movieToUpdate.getTitle());
			movieToUpdate.setComments(movieToUpdate.getComments());
			movieToUpdate.setWatchDate(movieToUpdate.getWatchDate());
			movieToUpdate.setRating(movieToUpdate.getRating());
			repository.save(movieToUpdate);
			return "Pelicula Actualizada";
		}
		
		return "Ha ocurrido un error al actualizar la pelicula";
	}
	
	

}
