package com.online.videostreaming.classrooms.onlineclassrooms.config;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StreamUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/");	
    }
	
	@Bean
	  public TilesConfigurer tilesConfigurer() {
	    TilesConfigurer tilesConfigurer = new TilesConfigurer();
	    tilesConfigurer.setDefinitions(
	        "/WEB-INF/tiles/tiles-resolver.xml");
	    tilesConfigurer.setCheckRefresh(true);
	    return tilesConfigurer;
	  }

	  @Bean
	  public TilesViewResolver tilesViewResolver() {
	    final TilesViewResolver resolver = new TilesViewResolver();
	    resolver.setViewClass(TilesView.class);
	    resolver.setOrder(0);
	    return resolver;
	  }
	  
		

	  public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
	        return new MappingJackson2HttpMessageConverter(){
	            @Override
	            protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
	                if(object instanceof String){
	                    Charset charset = Charset.defaultCharset();
	                    StreamUtils.copy((String)object, charset, outputMessage.getBody());
	                }else{
	                    super.writeInternal(object, type, outputMessage);
	                }
	            }
	        };
	    }

	    
		
		
		@Bean
		public MessageSource messageSource() {
		    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		    messageSource.setBasename("classpath:messages/messages");
		    messageSource.setDefaultEncoding("UTF-8");
		    return messageSource;
		}
		
		@Bean
		public LocalValidatorFactoryBean getValidator() {
		    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		    bean.setValidationMessageSource(messageSource());
		    return bean;
		}
		
}