package de.springbootbuch.database_examples.springdata;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface MoreExamplesRepository extends Repository<FilmEntity, Integer> {
	@Query(""
		+ " Select film from #{#entityName} film "
		+ " where :actor member of film.actors"
	)
	List<FilmEntity> findAllByActor(ActorEntity actor);	
}
