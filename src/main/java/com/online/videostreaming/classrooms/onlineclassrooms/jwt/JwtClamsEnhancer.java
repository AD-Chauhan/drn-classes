package com.online.videostreaming.classrooms.onlineclassrooms.jwt;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.core.oidc.endpoint.OidcParameterNames;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.online.videostreaming.classrooms.onlineclassrooms.entity.UsersEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.utils.WebConstant;

@Component
public class JwtClamsEnhancer implements TokenEnhancer {



	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		final String issuer = ServletUriComponentsBuilder.fromCurrentRequest().build().toString();
		final Map<String, Object> additionalInformation = new LinkedHashMap<>();
		final Instant expiration = accessToken.getExpiration().toInstant();
	
		additionalInformation.put(JwtClaimNames.ISS, issuer);
		additionalInformation.put(JwtClaimNames.EXP, expiration.getEpochSecond());
		additionalInformation.put(JwtClaimNames.IAT,
				expiration.minusSeconds(WebConstant.ACCESS_TOKEN_VALIDITY_SECONDS));
		additionalInformation.put(JwtClaimNames.AUD, WebConstant.CLIEN_ID);
		final String nonce = authentication.getOAuth2Request().getRequestParameters().get((OidcParameterNames.NONCE));
		if (nonce != null) {
			additionalInformation.put(OidcParameterNames.NONCE, nonce);
		}

		if (authentication.getPrincipal() instanceof UsersEntity) {
			 UsersEntity userDetails = (UsersEntity) authentication.getPrincipal();
			additionalInformation.put(JwtClaimNames.SUB, userDetails.getUserId());
			
			
		}

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
		return accessToken;
	}
}
