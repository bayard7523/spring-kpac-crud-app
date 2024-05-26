package com.bayard7523.kpac.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DBConfig {

	private final Properties applicationProperties;

	public DBConfig(@Qualifier("applicationProperties") Properties applicationProperties) {
		this.applicationProperties = applicationProperties;
	}

	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(applicationProperties.getProperty("database.driver"));
		dataSource.setUrl(applicationProperties.getProperty("database.url"));
		dataSource.setUsername(applicationProperties.getProperty("database.username"));
		dataSource.setPassword(applicationProperties.getProperty("database.password"));

		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() throws ClassNotFoundException {
		return new JdbcTemplate(dataSource());
	}
}
