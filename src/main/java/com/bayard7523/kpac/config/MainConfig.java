package com.bayard7523.kpac.config;

import com.bayard7523.kpac.component.validator.impl.PropertyValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Properties;

@Configuration
@PropertySource(value = {"classpath:application.properties", "classpath:test.server.properties"}, name = "application.properties")
@Import({
		DBConfig.class,
		WebConfig.class
})
public class MainConfig {

	@Bean
	public Properties applicationProperties(ConfigurableEnvironment environment,
	                                        PropertyValidator propertyValidator) {
		final Properties applicationProperties = (Properties) environment.getPropertySources().get("application.properties").getSource();

		propertyValidator.validate(applicationProperties);

		return applicationProperties;
	}
}
