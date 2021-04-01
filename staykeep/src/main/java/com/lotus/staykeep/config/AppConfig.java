package com.lotus.staykeep.config;

import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import bitronix.tm.resource.jdbc.PoolingDataSource;

/* The @Configuration annotation is a marker annotation which indicates that a
 * class declares one or more @Bean methods and may be processed by the Spring
 * container to generate bean definitions and service requests at runtime.
 */
@Configuration
@ComponentScan("com.lotus.staykeep") // @ComponentScan denotes where the Spring Container will look for components.
public class AppConfig {
	
	//DataSource info.	This information is required for the PostgreSql connection.
	public static final String DATASOURCE_DRIVERNAME = "org.postgresql.xa.PGXADataSource";

	//Database specific info. REal values held as environment variables.
	public static final String DATASOURCE_NAME = System.getenv("DB_NAME");
	public static final String DATASOURCE_PASSWORD = System.getenv("DB_PASSWORD");
	public static final String DATASOURCE_SCHEMA = System.getenv("DB_SCHEMA");
	public static final String DATASOURCE_URL = System.getenv("DB_URL");

	//This string makes for less typing in the long run.
	public static final String COMPLETE_URL = "jdbc:postgresql://" + DATASOURCE_URL + ":5432/" + DATASOURCE_NAME
			+ "?currentSchema=" + DATASOURCE_SCHEMA;
//-------------------------------------------------------------------------------------------------------------------------------------------------------

	// JDBC Data Source Configuration to set up PostgreSql connection.
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		PoolingDataSource dataSource = new PoolingDataSource();
		dataSource.setClassName(DATASOURCE_DRIVERNAME);
		dataSource.setUniqueName("PostGresDB");
		dataSource.setMaxPoolSize(10);
		dataSource.setAllowLocalTransactions(true);
		dataSource.getDriverProperties().put("Url", COMPLETE_URL);
		dataSource.getDriverProperties().put("user", DATASOURCE_NAME);
		dataSource.getDriverProperties().put("password", DATASOURCE_PASSWORD);
		dataSource.init();
		return dataSource;
	}

	// JDBC Template bean for efficiency
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	// Scanner bean for efficiency
	@Bean
	@Scope("singleton")
	public Scanner scan() {
		return new Scanner(System.in);
	}

	// Logger bean for efficiency
	@Bean
	public Logger log() {
		return Logger.getRootLogger();
	}
}