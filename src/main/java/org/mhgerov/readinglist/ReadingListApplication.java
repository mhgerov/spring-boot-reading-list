package org.mhgerov.readinglist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ReadingListApplication {

	static Logger logger = LoggerFactory.getLogger(ReadingListApplication.class);

	public static void main(final String[] args) {
		SpringApplication.run(ReadingListApplication.class, args);
		logger.info("My first custom INFO log!");
	}
}
