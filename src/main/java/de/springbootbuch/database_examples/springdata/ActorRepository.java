package de.springbootbuch.database_examples.springdata;

import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.Repository;

public interface ActorRepository extends Repository<ActorEntity, Integer> {
	Optional<ActorEntity> findOne(Example<ActorEntity> example);
}