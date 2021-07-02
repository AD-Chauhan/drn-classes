package com.online.videostreaming.classrooms.onlineclassrooms;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AppContext implements ApplicationContextAware {

    private String applicationId;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) 
            throws BeansException {

        applicationId = applicationContext.getId();
    }

    public String getApplicationId() {

        return applicationId;
    }
}
