package com.lotus.staykeep.config;

//import java.util.Properties;
//import java.util.Scanner;

//import javax.jms.ConnectionFactory;
//import javax.jms.Queue;
//import javax.jms.Topic;
import javax.sql.DataSource;
//import javax.transaction.TransactionManager;

//import org.apache.activemq.command.ActiveMQQueue;
//import org.apache.activemq.command.ActiveMQTopic;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.annotation.EnableJms;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.listener.DefaultMessageListenerContainer;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import com.lotus.staykeep.messaging.JmsMessageListener;

import bitronix.tm.TransactionManagerServices;
import bitronix.tm.resource.jdbc.PoolingDataSource;
import bitronix.tm.resource.jms.PoolingConnectionFactory;

/* The @Configuration annotation is a marker annotation which indicates that a
 * class declares one or more @Bean methods and may be processed by the Spring
 * container to generate bean definitions and service requests at runtime.
 */
@Configuration
/* The @ComponentScan annotation tells the Spring Container where in the program
 * to look for components.
 */
@ComponentScan("com.lotus.staykeep") 
/* The @EnableAspectJAutoProxy annotation enables support for handling 
 * components marked with AspectJ's @Aspect annotation.
 */
@EnableAspectJAutoProxy
/* The @EnableJms annotation triggers the discovery of methods annotated with 
 * @JmsListener, creating the message listener container under the covers.
 */
@EnableJms
/* To use Spring declarative transaction we need to use @EnableTransactionManagement 
 * on the configuration class and @Transactional annotation on the classes/methods 
 * where we want to enable the transaction.
 */
@EnableTransactionManagement
/* As far as I can tell, this is redundant with the @Configuration annotation.
 * So I commented it out.
 */
//@Component("config") 
/* In case we want to add the beans.xml from our soap to this config file.
 * Ask Nick for more details before using. 
 */
//@ImportResource({"classpath:beans.xml"})
public class AppConfig {
	
	/* JMS Broker Url.This is required to connect to ActiveMQ.
	 */
//	public static final String BROKER_URL = "tcp://localhost:61616";

	/* JMS Destinations.These are required to communicate with the Queue and the Topic.
	 */
//	public static final String QUEUE_NUMBER_ONE = "QUEUE_NUMBER_ONE";
//	public static final String TOPIC_NUMBER_ONE = "TOPIC_NUMBER_ONE";

	/* DataSource info.	This information is required for the ActiveMQ connection.
	 */
	public static final String DATASOURCE_DRIVERNAME = "org.postgresql.xa.PGXADataSource";
//	public static final String CONNECTIONFACTORY_DRIVERNAME = "org.apache.activemq.ActiveMQXAConnectionFactory";
	
	/* DataSource info.	This information is required for the JDBC template.
	 * Keep in mind the true values are hidden as environment variables. 
	 */
	public static final String DATASOURCE_URL = "jdbc:postgresql://" + System.getenv("DB_URL") + ":5432/" + System.getenv("DB_NAME");
	public static final String DATASOURCE_USERNAME = System.getenv("DB_NAME");
	public static final String DATASOURCE_PASSWORD = System.getenv("DB_PASSWORD");
	public static final String DATASOURCE_SCHEMA = System.getenv("DB_SCHEMA");

	/* Certain beans can close themselves to prevent resource leaks.
	 * (destroyMethod="close") is an example. In other words,
	 * this DataSource will close itself.
	 */ 
	@Bean(destroyMethod = "close")
	/* A factory for connections to the physical data source that this DataSource object represents. 
	 * An alternative to the DriverManager facility, a DataSource object is the preferred means of 
	 * getting a connection.
	 */
	public DataSource dataSource() {
		//WARNING: This method also has an object variable of the same name. Try not to get confused. 
		
		/* PoolingDataSource is a simple DataSource implementation that obtains Connections
		 * from the specified ObjectPool.
		 */
		PoolingDataSource dataSource = new PoolingDataSource();
		//Sets the class name to "org.postgresql.xa.PGXADataSource"
		dataSource.setClassName(DATASOURCE_DRIVERNAME);
		//This isn't a final string, so I assume it can be renamed.
		dataSource.setUniqueName("PostGresDB");
		// Max amount of objects in the ObjectPool. 10 is a safe number for a small app.
		dataSource.setMaxPoolSize(10); 
		// This allows transactions to occur.
		dataSource.setAllowLocalTransactions(true);
		/* STEP 1:Try not to be triggered by the capital U in Url.
		 * STEP 2: Get triggered anyway.
		 * This line sets the properties equal to the final strings defined above.
		 */
		dataSource.getDriverProperties().put("Url", DATASOURCE_URL);
		dataSource.getDriverProperties().put("user", DATASOURCE_USERNAME);
		dataSource.getDriverProperties().put("password", DATASOURCE_PASSWORD);
		//Starts the process.
		dataSource.init();
		//Returns the PoolingDataSource object.
		return dataSource;
	}

	/* The JDBC template exists so the process to connect to the Database isn't as arduous.
	 * All it requires is a datasource. Keep in mind it is a bean as well.
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	/* This bitronixConnectionFactory method handles the connection to our message Queue/Topic.
	 * It is set up almost identically to the dataSource method.
	 */
/*	
	@Bean
	public ConnectionFactory bitronixConnectionFactory() {
		//WARNING: This method also has an object variable of a similar name. Try not to get confused.
		
		// Similar to a PoolingDataSource
		PoolingConnectionFactory connectionFactory = new PoolingConnectionFactory();
		// Sets class name to "org.apache.activemq.ActiveMQXAConnectionFactory"
		connectionFactory.setClassName(CONNECTIONFACTORY_DRIVERNAME);
		//This isn't a final string, so I assume it can be renamed.
		connectionFactory.setUniqueName("activemq");
		// Max amount of objects in the ObjectPool. 10 is a safe number for a small app.
		connectionFactory.setMaxPoolSize(10);
		// This allows transactions to occur.
		connectionFactory.setAllowLocalTransactions(true);
		// A new Properties object must first be instantiated.
		Properties props = new Properties();
*/
		/* Similar to the dataSource properties assignment, but this time
		 * only the broker url to the stand-alone activeMQ implementation is required.
		 */
/*
		props.put("brokerURL", BROKER_URL);
*/
		/* This process puts the Properties into the connectionFactory
		 * to configure it as stated above.
		 */
/*
		connectionFactory.setDriverProperties(props);
*/
		// finally the PoolingConnectionFactory object is returned.
/*
		return connectionFactory;
	}
*/
	
/*
	// Declare the Queue as a bean.
	@Bean
	public Queue queueNumberOne() {
		return new ActiveMQQueue(QUEUE_NUMBER_ONE);
	}

	// Declare the Topic as a bean.
	@Bean
	public Topic destinationTopic() {
		return new ActiveMQTopic(TOPIC_NUMBER_ONE);
	}
*/
	//Similar to the JDBC template, but for JMS connections
/*	
	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory bitronixConnectionFactory) {
		//WARNING: This method also has an object variable of the same name. Try not to get confused. 
		
		// Instantiate a new jmsTemplate object.
		JmsTemplate jmsTemplate = new JmsTemplate();
		// Set the connectionfactory to the one created above.
		jmsTemplate.setConnectionFactory(bitronixConnectionFactory);
*/	
		/* Set the timeout to use for receive calls (in milliseconds).
		 * That's about 10 seconds.
		 */
/*
		jmsTemplate.setReceiveTimeout(10000);
		// Return the jmsTemplate Object.
		return jmsTemplate;
	}
*/
	
	// This is the DefaultMessageListenerContainer.
/*	
	@Bean
	public DefaultMessageListenerContainer jmsContainer(ConnectionFactory connectionFactory,
			JmsMessageListener messageListener) {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setDestinationName(TOPIC_NUMBER_ONE);
		container.setPubSubDomain(true);

		container.setMessageListener(messageListener);
		return container;
	}
*/
	// configure bitronix... to do... something.
	// Maybe get a config from Transaction Manager?
	// Ask Nick.
/*
	@Bean
	public bitronix.tm.Configuration btmConfig() {
		bitronix.tm.Configuration config = TransactionManagerServices.getConfiguration();
		config.setDisableJmx(true);
		config.setServerId("spring-btm");
		return config;
	}
*/
	// I remember that for certain beans we want to tell them which destroy method
	// to use on themselves when they have completed their task.
	// Note the all-important depends-on annotation.
/*
	@Bean(destroyMethod = "shutdown")
	@DependsOn("btmConfig")
	public TransactionManager primaryTransactionManager() {
		return TransactionManagerServices.getTransactionManager();
	}

	// Ok so a transactionmanager that takes... another transactionmanager
	// I still don't thoroughly understand JTA
	@Bean
	public JtaTransactionManager jtaTransactionManager(TransactionManager primaryTransactionManager) {
		JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
		jtaTransactionManager.setTransactionManager(primaryTransactionManager);
		return jtaTransactionManager;
	}

	//Scanner
	@Bean
	@Scope("singleton")
	public Scanner scan() {
		return new Scanner(System.in);
	}

	//Logger
	@Bean
	public Logger log() {
		return Logger.getRootLogger();
	}
*/
}