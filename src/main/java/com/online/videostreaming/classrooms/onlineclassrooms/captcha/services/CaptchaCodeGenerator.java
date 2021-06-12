package com.online.videostreaming.classrooms.onlineclassrooms.captcha.services;



import java.security.SignatureException;

import com.online.videostreaming.classrooms.onlineclassrooms.captcha.CaptchaCode;

public interface CaptchaCodeGenerator <T extends CaptchaCode> {

    T generateCaptchaCode(String key) throws SignatureException;

}
