package com.online.videostreaming.classrooms.onlineclassrooms.exceptions;

import org.springframework.security.web.csrf.CsrfException;


@SuppressWarnings("serial")
public class ExpiredCsrfTokenException extends CsrfException {

	public ExpiredCsrfTokenException(String message) {
		super(message);
	}

}