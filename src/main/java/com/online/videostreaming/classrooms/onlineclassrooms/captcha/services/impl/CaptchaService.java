package com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.impl;



import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.util.Formatter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base32;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.online.videostreaming.classrooms.onlineclassrooms.captcha.CaptchaCode;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.CaptchaType;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.ImgCaptchaKeyResponse;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.CaptchaCacheProvider;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.CaptchaCodeGenerator;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.FactoryRegistry;

@Service
public class CaptchaService {

	

	private static final Logger logger = LoggerFactory.getLogger(CaptchaService.class);

    @Autowired
    private FactoryRegistry<CaptchaType, CaptchaCodeGenerator> captchaGeneratorFactory;

    @Autowired
    private FactoryRegistry<CaptchaType, CaptchaCacheProvider<String, CaptchaCode>> cacheProviderFactory;
    
    
    public CaptchaCode genCaptchaCode(HttpServletRequest request,String key, CaptchaType codeType) throws SignatureException {
    	System.out.println("key"+key);
    	
        CaptchaCode validCode = getValidCaptchaCode(request,key, codeType);
        CaptchaCodeGenerator generator = captchaGeneratorFactory.getFactory(codeType);
        CaptchaCode code = generator.generateCaptchaCode(key);
        cacheProviderFactory.getFactory(codeType).put(request,key, new CaptchaCode(code)); // cache the clone object
        return code;
    }
    public boolean validateCaptchaCode(HttpServletRequest request,String key, String value, CaptchaType codeType) {
        
        CaptchaCode validCode = getValidCaptchaCode(request,key, codeType);
        
        System.out.println("validCode------"+validCode);
        return validCode != null && validCode.getValue().equals(value);
    }
    
	private CaptchaCode getValidCaptchaCode(HttpServletRequest request,String key, CaptchaType codeType) {
        try {
        	
            if (key!=null || !"".equals(key)) {
                return (CaptchaCode) cacheProviderFactory.getFactory(codeType).get(request,key);
            }
        } catch (Exception e) {
            logger.error("getValidCaptchaCode error, key: " + key, e);
        }
        return null;
    }
    
    
    public ImgCaptchaKeyResponse generateCaptchaKey() throws SignatureException {
		String HASH_ALGORITHM = "HmacSHA256";
		SecureRandom random = new SecureRandom();
		byte[] bytes = new byte[20];
		random.nextBytes(bytes);
		Base32 base32 = new Base32();
		String text = base32.encodeToString(bytes).toLowerCase().replaceAll("(.{4})(?=.{4})", "$1 ");

		try {
			Key sk = new SecretKeySpec("TLvuMIY+fzWYkX/ToCqyxp4WRNlAsUzDy+bQ6GCtUA4=".getBytes(), HASH_ALGORITHM);
			Mac mac = Mac.getInstance(sk.getAlgorithm());
			mac.init(sk);
			final byte[] hmac = mac.doFinal(text.getBytes());

			StringBuilder sb = new StringBuilder(hmac.length * 2);

			Formatter formatter = new Formatter(sb);
			for (byte b : hmac) {
				formatter.format("%02x", b);
			}
			ImgCaptchaKeyResponse imgCaptchaKeyResponse=	new ImgCaptchaKeyResponse();
			imgCaptchaKeyResponse.setCaptchaKey(sb.toString());
			
			
			return imgCaptchaKeyResponse;
		} catch (NoSuchAlgorithmException e1) {
			throw new SignatureException("error building signature, no such algorithm in device " + HASH_ALGORITHM);
		} catch (InvalidKeyException e) {
			throw new SignatureException("error building signature, invalid key " + HASH_ALGORITHM);
		}

		
	}
	
}
