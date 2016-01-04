package world.we.deserve;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

import world.we.deserve.dao.usuario;

@Component
public class App {
	@Autowired
	private CassandraOperations cassandraOperations;

	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(CassandraSpringComponentScan.class);
		App app = context.getBean(App.class);
		app.controlCassandra();
	}

	private void controlCassandra() {
		Insert insert = QueryBuilder.insertInto("usuario");
		insert.setConsistencyLevel(ConsistencyLevel.ONE);
		insert.value("id", UUID.randomUUID());
		insert.value("nombre", "Alison");
		insert.value("email", "gmailalgo");

		cassandraOperations.execute(insert);

		Select select = QueryBuilder.select().from("demo", "usuario");

		select.limit(100);

		List<usuario> results = cassandraOperations.select(select, usuario.class);

		results.forEach(r -> System.out.println(r));
	}
}
