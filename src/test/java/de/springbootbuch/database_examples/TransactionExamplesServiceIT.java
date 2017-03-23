package de.springbootbuch.database_examples;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.jdbc.JdbcTestUtils.countRowsInTableWhere;

@RunWith(SpringRunner.class)
@JdbcTest(
	includeFilters = @Filter(value = Service.class))
@AutoConfigureTestDatabase(replace = NONE)
public class TransactionExamplesServiceIT {

	@Autowired
	private TransactionExamplesService examplesService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	@Rollback(false)
	public void tryInsertShouldWork() {
		try {
			examplesService.tryInsert();
		} catch(RuntimeException e) {
			assertThat(e.getMessage(),
				is("Some error here..."));			
		}
		assertThat(
			countRowsInTableWhere(
				jdbcTemplate, 
				"actor", "first_name like 'Chuck%'"), 
			is(0));
	}
	
	@Test	
	public void doInsertShouldWork() {
		examplesService.doInsert();
		assertThat(
			countRowsInTableWhere(
				jdbcTemplate, 
				"actor", "first_name like 'Chuck%'"), 
			is(1));
	}
	
	@Test
	public void countSomethingShouldWork() {
		assertThat(examplesService.countSomething(), is(greaterThan(0L)));
	}
}