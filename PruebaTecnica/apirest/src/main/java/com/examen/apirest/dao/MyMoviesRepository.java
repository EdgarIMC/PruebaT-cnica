package com.examen.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examen.apirest.dto.MyMovies;

public interface MyMoviesRepository extends JpaRepository<MyMovies, Long>{

}
