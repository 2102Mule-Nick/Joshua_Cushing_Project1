package com.lotus.staykeep.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import bitronix.tm.resource.jdbc.PoolingDataSource;

@Configuration
@ComponentScan("com.lotus.staykeep") 
public class AppConfig {
	
	public static final String DATASOURCE_DRIVERNAME = "org.postgresql.xa.PGXADataSource";
	
	public static final String DATASOURCE_NAME = System.getenv("DB_NAME");
	public static final String DATASOURCE_PASSWORD = System.getenv("DB_PASSWORD");
	public static final String DATASOURCE_SCHEMA = System.getenv("DB_SCHEMA");
	public static final String DATASOURCE_URL = System.getenv("DB_URL");
	
	public static final String COMPLETE_URL = "jdbc:postgresql://" + DATASOURCE_URL + ":5432/" + DATASOURCE_NAME + "?currentSchema=" + DATASOURCE_SCHEMA;
//-------------------------------------------------------------------------------------------------------------------------------------------------------
	
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


	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}