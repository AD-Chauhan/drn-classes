 package com.online.videostreaming.classrooms.onlineclassrooms.config;

import java.security.KeyPair;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.online.videostreaming.classrooms.onlineclassrooms.jwt.IdTokenEnhancer;
import com.online.videostreaming.classrooms.onlineclassrooms.jwt.JwtClamsEnhancer;
import com.online.videostreaming.classrooms.onlineclassrooms.jwt.JwtProperties;
import com.online.videostreaming.classrooms.onlineclassrooms.utils.WebConstant;




@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
    private ClientDetailsService clientDetailsService;
    private final KeyPair keyPair;
    private final JwtClamsEnhancer jwtClamsEnhancer;
    public AuthorizationServerConfig( JwtProperties props, JwtClamsEnhancer jwtClamsEnhancer) throws Exception {
        this.keyPair = props.getKeyPair();
        this.jwtClamsEnhancer = jwtClamsEnhancer;
    }
    
    @Autowired
   	private WebResponseExceptionTranslator loggingExceptionTranslator;
    
	
	
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(this.jwtClamsEnhancer, jwtAccessTokenConverter(), new IdTokenEnhancer(jwtAccessTokenConverter())));
        endpoints
                .authenticationManager(authenticationManager)
                .tokenEnhancer(tokenEnhancerChain)
                .tokenStore(tokenStore());
        
        endpoints.requestFactory(customOAuth2RequestFactory());
        endpoints.exceptionTranslator(loggingExceptionTranslator);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
    	configurer
		.inMemory()
		.withClient(WebConstant.CLIEN_ID)
		.secret(passwordEncoder.encode(WebConstant.CLIENT_SECRET) )
		.authorizedGrantTypes(WebConstant.GRANT_TYPE_PASSWORD, WebConstant.CLIENT_CREDENTIALS, WebConstant.REFRESH_TOKEN, WebConstant.IMPLICIT )
		.scopes(WebConstant.SCOPE_READ, WebConstant.SCOPE_WRITE)
		.accessTokenValiditySeconds(WebConstant.ACCESS_TOKEN_VALIDITY_SECONDS).
		refreshTokenValiditySeconds(WebConstant.FREFRESH_TOKEN_VALIDITY_SECONDS);
}
    

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(this.keyPair);
        
        return converter;
    }
    @Bean
    public DefaultOAuth2RequestFactory customOAuth2RequestFactory(){
    	return new CustomOAuth2RequestFactory(clientDetailsService);
    }
    
    @Autowired
	@Qualifier("authenticationManagerBean") 
	private AuthenticationManager authenticationManager;
}
