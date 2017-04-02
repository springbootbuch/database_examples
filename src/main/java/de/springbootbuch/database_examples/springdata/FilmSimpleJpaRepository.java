package de.springbootbuch.database_examples.springdata;

import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.data.repository.Repository;

public interface FilmSimpleJpaRepository 
	extends Repository<FilmEntity, Integer> {
	
	Optional<FilmEntity> findOne(Integer id);
	
	Stream<FilmEntity> findAll();
	
	long countAllByTitleLike(String name);
}