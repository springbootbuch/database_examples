/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.springbootbuch.database_examples;

import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@JdbcTest(
	includeFilters = 
		@ComponentScan.Filter(value = FilmJOOQRepository.class, type = ASSIGNABLE_TYPE)
)
@AutoConfigureTestDatabase(replace = NONE)
@ImportAutoConfiguration(JooqAutoConfiguration.class)
public class FilmJOOQRepositoryIT {
	
	@Autowired
	private FilmJOOQRepository filmJOOQRepository;
	
	@Test
	public void findAllShouldWork() {
		final List<Film> films = filmJOOQRepository.findAll();
		assertThat(films.size(), is(greaterThan(0)));		
	}
}