package com.online.videostreaming.classrooms.onlineclassrooms.config;



import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.online.videostreaming.classrooms.onlineclassrooms.drnusers.service.EndUserDetailsService;



public class CustomOAuth2RequestFactory extends DefaultOAuth2RequestFactory {
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomOAuth2RequestFactory.class);

    public static final String SAVED_AUTHORIZATION_REQUEST_SESSION_ATTRIBUTE_NAME = "savedAuthorizationRequest";
    @Autowired
	private TokenStore tokenStore;

    @Autowired @Qualifier("endUserDetailsService") EndUserDetailsService endUserDetailsService;
   
    public CustomOAuth2RequestFactory(ClientDetailsService clientDetailsService) {
        super(clientDetailsService);
    }

    @Override
    public AuthorizationRequest createAuthorizationRequest(Map<String, String> authorizationParameters) {
    	  	
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(false);
        if (session != null) {
            AuthorizationRequest authorizationRequest = (AuthorizationRequest) session.getAttribute(SAVED_AUTHORIZATION_REQUEST_SESSION_ATTRIBUTE_NAME);
            if (authorizationRequest != null) {
                session.removeAttribute(SAVED_AUTHORIZATION_REQUEST_SESSION_ATTRIBUTE_NAME);
                
                
                LOG.debug("createAuthorizationRequest(): return saved copy.");
                
                return authorizationRequest;
            }
        }

        LOG.debug("createAuthorizationRequest(): create");
        return super.createAuthorizationRequest(authorizationParameters);
    }
    
    
    @Override
	public TokenRequest createTokenRequest(Map<String, String> requestParameters, ClientDetails authenticatedClient) {
		System.out.println("refresh...............");
		if (requestParameters.get("grant_type").equals("refresh_token")) {
			System.out.println("refresh...............");
			OAuth2Authentication authentication = tokenStore.readAuthenticationForRefreshToken(
					tokenStore.readRefreshToken(requestParameters.get("refresh_token")));
			System.out.println("refresh..............."+requestParameters.get("refresh_token")+authentication.getName());
			SecurityContextHolder.getContext()
					.setAuthentication(new UsernamePasswordAuthenticationToken(authentication.getName(), null,
							endUserDetailsService.loadUserByUsername(authentication.getName()).getAuthorities()));
			System.out.println("refresh...............");
		}
		
	
		System.out.println("refresh...............");
		return super.createTokenRequest(requestParameters, authenticatedClient);
	}
    

}