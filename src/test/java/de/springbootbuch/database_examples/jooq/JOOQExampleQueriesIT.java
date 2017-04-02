package de.springbootbuch.database_examples.jooq;

import static de.springbootbuch.database_examples.jooq.Tables.LANGUAGE;
import static de.springbootbuch.database_examples.jooq.Tables.ACTOR;
import java.util.Map;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.jooq.Record3;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@JdbcTest
(
	includeFilters = 
		@ComponentScan.Filter(value = JOOQExampleQueries.class, type = ASSIGNABLE_TYPE)
)
@ImportAutoConfiguration(JooqAutoConfiguration.class)
public class JOOQExampleQueriesIT {
	
	private static final Logger LOG = LoggerFactory
		.getLogger(JOOQExampleQueriesIT.class);

	@Autowired
	private JOOQExampleQueries exampleQueries;
	

	@Test
	public void generateStatisticsShouldWork() {
		 Map<String, Record3<String, String, Integer>> stats =
			 exampleQueries.generateLanguageStatistics();
		 Assert.assertThat(stats.size(), is(equalTo(121)));
		 stats.forEach((k, v) -> LOG.info("{}: {} {} movies", v.get(ACTOR.LAST_NAME), v.get(LANGUAGE.NAME), v.get(2)));
	}
}