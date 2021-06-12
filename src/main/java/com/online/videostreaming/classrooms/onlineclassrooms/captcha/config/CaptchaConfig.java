package com.online.videostreaming.classrooms.onlineclassrooms.captcha.config;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.online.videostreaming.classrooms.onlineclassrooms.captcha.CaptchaCode;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.CaptchaType;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.CaptchaCacheProvider;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.CaptchaCodeGenerator;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.FactoryRegistry;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.impl.CaptchaService;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.impl.CaptchaSessionCacheProviderImpl;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.impl.DefaultFactoryRegistry;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.impl.ImgCaptchaGenerator;


@Configuration

@EnableConfigurationProperties({ImgCaptchaProperties.class})
public class CaptchaConfig/* extends DefaultCaptchaConfig */{


   
    @Autowired
    protected ImgCaptchaProperties imgCaptchaProperties;

    
    @Autowired
    private HttpServletRequest httpServletRequest;
   
    @Bean
    public FactoryRegistry<CaptchaType, CaptchaCodeGenerator> captchaGeneratorFactory() {
        return new DefaultFactoryRegistry<CaptchaType, CaptchaCodeGenerator>()
                .registerFactory(CaptchaType.IMG, new ImgCaptchaGenerator(imgCaptchaProperties))
                ;
    }
    
    @Bean
    public FactoryRegistry<CaptchaType, CaptchaCacheProvider<String, CaptchaCode>> cacheProviderFactory() {
        return new DefaultFactoryRegistry<CaptchaType, CaptchaCacheProvider<String, CaptchaCode>>()
                .registerFactory(CaptchaType.IMG,
                        new CaptchaSessionCacheProviderImpl<>())
                ;
    }
}
