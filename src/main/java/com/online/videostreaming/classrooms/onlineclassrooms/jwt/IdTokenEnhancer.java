package com.online.videostreaming.classrooms.onlineclassrooms.jwt;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.core.oidc.endpoint.OidcParameterNames;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersEntity;

public class IdTokenEnhancer implements TokenEnhancer {
    private final JwtAccessTokenConverter jwtAccessTokenConverter;
   
    public IdTokenEnhancer(JwtAccessTokenConverter jwtAccessTokenConverter) {
        this.jwtAccessTokenConverter = jwtAccessTokenConverter;
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        if (accessToken.getScope().contains(OidcScopes.OPENID)) {
        	 Map<String, Object> additionalInformation = Collections.emptyMap();
        	if (authentication.getPrincipal() instanceof UsersEntity) {
    			
    			try {
    				
    				UsersEntity userDetails = (UsersEntity) authentication.getPrincipal();
    				additionalInformation.put("name", userDetails.getFirstName());
    				additionalInformation.put("mobile", userDetails.getPhone());
    				additionalInformation.put("email", userDetails.getEmail());
    				additionalInformation.put("created_on", userDetails.getCreatedOn());
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			
    		}
        	((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
            final DefaultOAuth2AccessToken idToken = new DefaultOAuth2AccessToken(accessToken);
            idToken.setScope(new HashSet<String>(Arrays.asList(OidcScopes.OPENID)));
            idToken.setRefreshToken(null);
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(Collections.singletonMap(OidcParameterNames.ID_TOKEN, this.jwtAccessTokenConverter.enhance(idToken, authentication).getValue()));
        }
        return accessToken;
    }
}
