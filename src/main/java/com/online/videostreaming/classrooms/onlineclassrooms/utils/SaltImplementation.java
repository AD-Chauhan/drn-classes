package com.online.videostreaming.classrooms.onlineclassrooms.utils;

import java.util.Base64;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class SaltImplementation {
	public final static String saltKey = "LnKrwxR";
	public final static String securityKey = "kywx";

	public static void main(String[] args) {


		String user = "EVA:EVA@2020";


		String encodedString = Base64.getEncoder().encodeToString(user.getBytes());
		
		
		
		encodedString=saltKey+securityKey+encodedString;
		encodedString=encodedString.replace(saltKey, "");
		System.out.println("Deep1  ========== " +  TextCodec.BASE64.encode(encodedString));
		encodedString=encodedString.replace(securityKey, "");
		System.out.println("Deep1  ========== " +  TextCodec.BASE64.encode(encodedString));
		
		byte[] decodedBytes = Base64.getDecoder().decode("cmFqZWV2Lmt1bWFyQGluLmZjbS50cmF2ZWw=");
		String decodedString = new String(decodedBytes);
		System.out.println("Deep3  ===>>>>>>>>>====== " + decodedString);

	}

}
