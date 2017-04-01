package de.springbootbuch.database_examples.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmJpaRepository 
	extends JpaRepository<FilmEntity, Integer> {	
}