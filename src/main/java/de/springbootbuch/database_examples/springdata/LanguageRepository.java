package de.springbootbuch.database_examples.springdata;

import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface LanguageRepository extends Repository<LanguageEntity, Integer> {
	Optional<LanguageEntity> findOneByName(String name);
}