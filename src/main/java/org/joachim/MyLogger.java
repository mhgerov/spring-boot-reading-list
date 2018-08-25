package org.joachim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class MyLogger {

	private static final Logger LOG = LoggerFactory.getLogger(MyLogger.class);

	@Scheduled(fixedDelay = 2000)
	public void doSomething() {
		LOG.info("Test");
	}

}
