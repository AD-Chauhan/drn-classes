package com.online.videostreaming.classrooms.onlineclassrooms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ConfigurationPropertiesScan
public class OnlineClassroomsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineClassroomsApplication.class, args);
	}

	
}
