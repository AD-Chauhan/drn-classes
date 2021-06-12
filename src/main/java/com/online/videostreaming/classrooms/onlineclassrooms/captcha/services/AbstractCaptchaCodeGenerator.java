package com.online.videostreaming.classrooms.onlineclassrooms.captcha.services;



import java.security.SecureRandom;
import java.util.Random;

public abstract class AbstractCaptchaCodeGenerator implements CaptchaCodeGenerator {

    protected int resendIntervals = -1;
    protected int codeLength;
    protected boolean debugMode = false;
    private static final char[] CHARS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
			'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3',
			'4', '5', '6', '7', '8', '9'};
		
    private Random rand;
    public AbstractCaptchaCodeGenerator(int codeLength, boolean debugMode) {
        this.codeLength = codeLength;
        this.debugMode = debugMode;
    }

    public AbstractCaptchaCodeGenerator(int resendIntervals, int codeLength, boolean debugMode) {
        this.resendIntervals = resendIntervals;
        this.codeLength = codeLength;
        this.debugMode = debugMode;
    }

    protected String genCaptchaCodeValue(int length) {
    	this.rand = new SecureRandom();
    	StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(CHARS[rand.nextInt(CHARS.length)]);
		}
		return sb.toString();
    }

    

}
