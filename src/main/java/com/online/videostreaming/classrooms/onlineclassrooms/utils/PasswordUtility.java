package com.online.videostreaming.classrooms.onlineclassrooms.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class PasswordUtility {



	
	 public static String getSecureSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
	  		String salt =  getSalt();
	      MessageDigest md = MessageDigest.getInstance("MD5");
	      md.update(salt.getBytes());
	      byte[] bytes = md.digest();
	      StringBuilder generatedSalt = new StringBuilder();
	      for(int i = 0; i< bytes.length ;i++) {
	      	generatedSalt.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	      }
	      return generatedSalt.toString();
	  }
	  
	  private static String getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
	      SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
	      byte[] salt = new byte[16];
	      sr.nextBytes(salt);
	      return salt.toString();
	  }

}
