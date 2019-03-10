package com.SJBProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = { SjbProjectApplication.class, Jsr310JpaConverters.class })
public class SjbProjectApplication {

	private static final Logger log = LogManager.getLogger(SjbProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SjbProjectApplication.class, args);
	}

}
