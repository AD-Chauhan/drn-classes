package com.online.videostreaming.classrooms.onlineclassrooms.serviceImpl;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.lang.Assert;
@Service
public class LoginPasswordService {

    private Map<String, String> secrets = new HashMap<>();
    private Map<String, String> keys = new HashMap<>();

    public final static String saltKey = "LnKrwxR";
	public final static String securityKey = "kywx";
	private final String user ;
	private final String encodedString ;

    



	public LoginPasswordService() {
		this.user = "EVA:EVA@2020";
		this.encodedString = saltKey+securityKey+Base64.getEncoder().encodeToString(user.getBytes());
	}





	public Map<String, String> getKeys() {
		return keys;
	}





	public void setKeys(Map<String, String> keys) {
		Assert.notNull(keys);
        Assert.hasText(keys.get(SignatureAlgorithm.HS256.getValue()));

        this.keys = keys;
	}





	public Map<String, String> getSecrets() {
        return secrets;
    }

    public void setSecrets(Map<String, String> secrets) {
        Assert.notNull(secrets);
        Assert.hasText(secrets.get(SignatureAlgorithm.HS256.getValue()));

        this.secrets = secrets;
    }

    public byte[] getHS256SecretBytes() {
        return TextCodec.BASE64.decode(secrets.get(SignatureAlgorithm.HS256.getValue()));
    }
    
    public byte[] getHS256KeysBytes() {
        return TextCodec.BASE64.decode(keys.get(SignatureAlgorithm.HS256.getValue()));
    }

    


    public Map<String, String> refreshSecrets() {
    	
        secrets.put(SignatureAlgorithm.HS256.getValue(), TextCodec.BASE64.encode(this.encodedString.replace(securityKey, "")));
        return secrets;
    }
    
    public Map<String, String> refreshKeys() {
        keys.put(SignatureAlgorithm.HS256.getValue(), TextCodec.BASE64.encode(this.encodedString.replace(saltKey, "")));
        return keys;
    }
}
