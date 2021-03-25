package com.lotus.frontdesk.config;

import java.util.Properties;
import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.lotus.frontdesk.messaging.JmsMessageListener;

import bitronix.tm.TransactionManagerServices;
import bitronix.tm.resource.jdbc.PoolingDataSource;
import bitronix.tm.resource.jms.PoolingConnectionFactory;

@Configuration
@ComponentScan("com.lotus.frontdesk")
@EnableJms
@EnableTransactionManagement
@Component("config")
public class AppConfig {
	// JMS Broker Url
	public static final String BROKER_URL = "tcp://localhost:61616";

	// JMS Destinations
	public static final String QUEUE_NUMBER_ONE = "QUEUE_NUMBER_ONE";
	public static final String TOPIC_NUMBER_ONE = "TOPIC_NUMBER_ONE";

	// DataSource info
	// This seems to have replaced our regular JDBC auth info
	public static final String DATASOURCE_URL = "jdbc:postgresql://" + System.getenv("DB_URL") + ":5432/"
			+ System.getenv("DB_NAME");
	public static final String DATASOURCE_DRIVERNAME = "org.postgresql.xa.PGXADataSource";
	public static final String DATASOURCE_USERNAME = System.getenv("DB_NAME");
	public static final String DATASOURCE_PASSWORD = System.getenv("DB_PASSWORD");
	public static final String DATASOURCE_SCHEMA = System.getenv("DB_SCHEMA");

	// I remember that for certain beans we want to tell them which destroy
	// method to use on themselves when they have completed their task.
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		PoolingDataSource dataSource = new PoolingDataSource();
		dataSource.setClassName(DATASOURCE_DRIVERNAME);
		dataSource.setUniqueName("PostGresDB");
		dataSource.setMaxPoolSize(10); // We probably won't need more than 10?
		dataSource.setAllowLocalTransactions(true);
		dataSource.getDriverProperties().put("Url", DATASOURCE_URL);
		dataSource.getDriverProperties().put("user", DATASOURCE_USERNAME);
		dataSource.getDriverProperties().put("password", DATASOURCE_PASSWORD);
		dataSource.init();
		return dataSource;
		// So, this whole block of code basically sets our database as a datasource, a
		// and then sets that datasource to a bean so we can...
		// access the connection whenever we want? I Think?
	}

	// I know the template exists so we don't have to go through a huge process to
	// connect to our DB.
	// I just don't know how it does it. All I know is that we have to plug in our
	// datasource.
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	// I believe this handles the connection to our message Q/topic
	@Bean
	public ConnectionFactory bitronixConnectionFactory() {
		PoolingConnectionFactory connectionFactory = new PoolingConnectionFactory();
		connectionFactory.setClassName("org.apache.activemq.ActiveMQXAConnectionFactory");
		connectionFactory.setUniqueName("activemq");
		connectionFactory.setMaxPoolSize(10); // We probably won't need more than 10?
		connectionFactory.setAllowLocalTransactions(true);
		Properties props = new Properties();
		props.put("brokerURL", BROKER_URL);
		connectionFactory.setDriverProperties(props);
		return connectionFactory;
	}

	// Makes our q into beans
	@Bean
	public Queue queueNumberOne() {
		return new ActiveMQQueue(QUEUE_NUMBER_ONE);
	}

	// Makes our topic into beans
	@Bean
	public Topic destinationTopic() {
		return new ActiveMQTopic(TOPIC_NUMBER_ONE);
	}

	// OK so this is so we can connect to our q/topic without a big hassle. I get
	// it.
	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory bitronixConnectionFactory) {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(bitronixConnectionFactory);
		jmsTemplate.setReceiveTimeout(10000);
		return jmsTemplate;
	}

	// Also it should be noted this is reading from our topic_number_one
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

	// configure bitronix... to do... something.
	// Maybe get a config from Transaction Manager?
	@Bean
	public bitronix.tm.Configuration btmConfig() {
		bitronix.tm.Configuration config = TransactionManagerServices.getConfiguration();
		config.setDisableJmx(true);
		config.setServerId("spring-btm");
		return config;
	}
	
	// I remember that for certain beans we want to tell them which destroy method
	// to use on themselves when they have completed their task.
	// Note the all-important depends-on annotation.
	@Bean(destroyMethod = "shutdown")
	@DependsOn("btmConfig")
	public TransactionManager primaryTransactionManager() {
		return TransactionManagerServices.getTransactionManager();
	}

	// Ok so a transactionmanager that takes... another transactionmanager
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

}