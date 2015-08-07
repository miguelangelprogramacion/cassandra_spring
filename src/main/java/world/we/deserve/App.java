package world.we.deserve;

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

@Component
public class App 
{
	@Autowired
	private CassandraOperations cassandraOperations;
	
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args )
    {
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
	}
}
