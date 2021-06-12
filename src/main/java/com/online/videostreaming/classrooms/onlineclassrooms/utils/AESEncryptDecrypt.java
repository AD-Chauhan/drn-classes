package com.online.videostreaming.classrooms.onlineclassrooms.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryptDecrypt {

	public static String decrypt(String strToDecrypt, String secret)
			throws NoSuchAlgorithmException, NoSuchPaddingException, Exception {

		byte[] cipherWithIv = Base64.getDecoder().decode(strToDecrypt);
		byte[] plainkey = Base64.getDecoder().decode(secret);
		byte[] iv = new byte[16];
		System.arraycopy(cipherWithIv, 0, iv, 0, iv.length);
		byte[] encryptedData = new byte[cipherWithIv.length - iv.length];
		System.arraycopy(cipherWithIv, iv.length, encryptedData, 0, encryptedData.length);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
		SecretKeySpec secretKey = new SecretKeySpec(plainkey, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
		return new String(cipher.doFinal(encryptedData));

	}

	public static String encrypt(String strToEncrypt, String secret)
			throws NoSuchAlgorithmException, NoSuchPaddingException, Exception {

		byte[] plainkey = Base64.getDecoder().decode(secret);
		SecretKeySpec secretKey = new SecretKeySpec(plainkey, "AES");

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		SecureRandom secureRandom = new SecureRandom();
		byte iv[] = new byte[16];
		secureRandom.nextBytes(iv);

		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
		byte[] encryptedData = cipher.doFinal(strToEncrypt.getBytes("UTF-8"));
		byte[] cipherWithIv = new byte[iv.length + encryptedData.length];
		System.arraycopy(iv, 0, cipherWithIv, 0, iv.length);
		System.arraycopy(encryptedData, 0, cipherWithIv, iv.length, encryptedData.length);
		return Base64.getEncoder().encodeToString(cipherWithIv);

	}

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, Exception {

		AESEncryptDecrypt ase = new AESEncryptDecrypt();

		String s = "mSrbdE5FzEnZz0AIZ+uaOzVOdcpuOOgcYbgT/ZKM3YY=";
		String secret = "TLvuMIY+fzWYkX/ToCqyxp4WRNlAsUzDy+bQ6GCtUA4=";
		String de = ase.encrypt(s, secret);
		System.out.println(de);
		System.out.println(ase.decrypt(de, secret));
	}

}
