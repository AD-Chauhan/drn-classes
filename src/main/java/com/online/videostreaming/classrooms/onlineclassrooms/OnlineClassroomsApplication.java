package com.online.videostreaming.classrooms.onlineclassrooms;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ConfigurationPropertiesScan
public class OnlineClassroomsApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(OnlineClassroomsApplication.class);
	}
	public static void main(String[] args) {
		
		
		SpringApplication.run(OnlineClassroomsApplication.class, args);
	}
	
	
	
	

}

