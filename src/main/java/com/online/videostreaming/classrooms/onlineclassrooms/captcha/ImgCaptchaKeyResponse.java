package com.online.videostreaming.classrooms.onlineclassrooms.captcha;

import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.util.Formatter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base32;

public class ImgCaptchaKeyResponse implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  String captchaKey;
	
	private byte[] imgByte;



	public String getCaptchaKey() {
		return captchaKey;
	}




	public void setCaptchaKey(String captchaKey) {
		this.captchaKey = captchaKey;
	}




	public byte[] getImgByte() {
		return imgByte;
	}




	public void setImgByte(byte[] imgByte) {
		this.imgByte = imgByte;
	}




	
	
}
