package org.mhgerov.readinglist;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!test")
@ImportResource("classpath:integration.xml")
public class BookApplicationConfiguration {

}
