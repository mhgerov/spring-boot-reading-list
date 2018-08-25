package org.joachim;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Bean
	@ConditionalOnProperty(name = "michal.log.enabled", havingValue = "true", matchIfMissing = false)
	public MyLogger myLogger() {
		return new MyLogger();
	}

}
