package com.online.videostreaming.classrooms.onlineclassrooms.config;

import java.util.HashMap;
import java.util.Map;

import org.directwebremoting.spring.DwrSpringServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;

import com.online.videostreaming.classrooms.onlineclassrooms.filters.DWRFilter;
@Configuration
@ImportResource(locations = "classpath:dwr-config.xml")
public class DwrConfig {
	    @Bean
	    public ServletRegistrationBean<DwrSpringServlet> servletRegistrationBean() {
	    	ServletRegistrationBean<DwrSpringServlet> registration = new ServletRegistrationBean<DwrSpringServlet>(new DwrSpringServlet());
	        registration.setName("dwr-invoker");
	        registration.setEnabled(true);
	        registration.addUrlMappings("/drnclasses/*");
	        Map<String, String> initParameters = new HashMap<>(1);
	        initParameters.put("debug", "true");
	        initParameters.put("debug", "true");
	        registration.setInitParameters(initParameters);
	        return registration;
	    }

	    
	    @Bean
	    @Primary
	    public DWRFilter shareFilterRegistration() {
	        return new DWRFilter();
	    }
}
