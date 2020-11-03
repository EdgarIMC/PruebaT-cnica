package com.examen.apirest.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.examen.apirest.dto.Movie;
import com.examen.apirest.dto.MyMovies;
import com.examen.apirest.services.MyMovieService;

@Controller
public class MyMoviesController implements IMyMoviesController{
	
	@Autowired
	private MyMovieService service;
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	@RequestMapping(value = "movies/search/{name}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getMovie(@PathVariable String name) {
		String movies = restTemplate.getForObject("http://www.omdbapi.com/?t="+name+"&apikey=b84c77da&", String.class);
		return movies;
	}
	@Override
	@RequestMapping(value = "/movies", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Movie> getMovies() {
		
		Movie movieDetail = new Movie();
		List<MyMovies> movieslist = service.findAllMovies();
		ArrayList<Movie> moviesdetail = new ArrayList<Movie>();
		for(MyMovies movie:movieslist){
			Movie movies = restTemplate.getForObject("http://www.omdbapi.com/?t="+movie.getTitle()+"&apikey=b84c77da&", Movie.class);
			movieDetail.setId(movie.getId());
			movieDetail.setTitle(movie.getTitle());
			movieDetail.setWatchDate(movie.getWatchDate());
			movieDetail.setImdbID(movies.getImdbID());
			movieDetail.setRating(movie.getRating());
			movieDetail.setComments(movie.getComments());
			moviesdetail.add(movieDetail);
		}
		
		return moviesdetail;
	}

	@Override
	@RequestMapping(value = "/movies/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Movie getMovieById(@PathVariable Long id) {
		Optional<MyMovies> movie = service.findMovieById(id);
		Movie movieDetail = new Movie();
		Movie movies = restTemplate.getForObject("http://www.omdbapi.com/?t="+movie.get().getTitle()+"&apikey=b84c77da&", Movie.class);
		movieDetail.setId(movie.get().getId());
		movieDetail.setTitle(movie.get().getTitle());
		movieDetail.setWatchDate(movie.get().getWatchDate());
		movieDetail.setImdbID(movies.getImdbID());
		movieDetail.setRating(movie.get().getRating());
		movieDetail.setComments(movie.get().getComments());
		return movieDetail;
	}

	@Override
	@RequestMapping(value = "/movies/add", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public MyMovies addMovie(MyMovies movie) {
		return service.saveMovie(movie);
	}

	@Override
	@RequestMapping(value = "/movies/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String deleteMovie(@PathVariable Long id) {
		return service.deleteMovie(id);
	}

	@Override
	@RequestMapping(value = "/movies/update", method = RequestMethod.PATCH, produces = "application/json")
	@ResponseBody
	public String updateMovie(MyMovies updateMovie) {
		return service.updateMovie(updateMovie);
	}
}
