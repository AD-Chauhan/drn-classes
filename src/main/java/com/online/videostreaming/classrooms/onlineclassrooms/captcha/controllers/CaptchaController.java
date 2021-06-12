package com.online.videostreaming.classrooms.onlineclassrooms.captcha.controllers;

import java.io.IOException;
import java.security.SignatureException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.videostreaming.classrooms.onlineclassrooms.captcha.CaptchaCode;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.CaptchaResponse;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.CaptchaType;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.ImgCaptchaCode;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.ImgCaptchaKeyResponse;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.exception.BusinessException;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.exception.ErrorCode;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.impl.CaptchaService;
import com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.impl.ImgCaptchaGenerator;

@Controller
@RequestMapping("/admin")

public class CaptchaController {

	
	//in.nic.icjsinteroperabilitynew.authorizationserver.encryptbody.config
	@Autowired
	private CaptchaService captchaService;
	
	@RequestMapping(value = "/imgCaptcha", method = RequestMethod.GET)
	public @ResponseBody void  genImgCaptcha(HttpServletRequest request, HttpServletResponse response)
			throws SignatureException, IOException {

		String sessionId = request.getSession().getId();
        CaptchaCode captchaCode = captchaService.genCaptchaCode(request,"CAPTCHA_KEY"+sessionId, CaptchaType.IMG);
        if (captchaCode != null && captchaCode instanceof ImgCaptchaCode) {
        	ImgCaptchaGenerator.outputToHttpServletResponse((ImgCaptchaCode) captchaCode, response);
        } else {
            throw new BusinessException(ErrorCode.FAILED);
        }

	}

	@RequestMapping(value = "/validateCaptcha", method = RequestMethod.POST)
	public @ResponseBody CaptchaResponse validateCaptcha(@RequestParam("captchaAnswer") String imgCaptcha,
			@RequestParam("captchaKey") String captchaKey, HttpServletRequest request, HttpServletResponse response) {

		validateCaptcha(request,captchaKey, imgCaptcha, CaptchaType.IMG);
		return new CaptchaResponse(ErrorCode.SUCCESS);
	}

	
	
	private void validateCaptcha(HttpServletRequest request,String key, String value, CaptchaType type) {
		
			if (!captchaService.validateCaptchaCode(request,key, value, type)) {
				throw new BusinessException(ErrorCode.FAILED, String.format("wrong %s captcha", type.name()));
			}
		
	}

}
