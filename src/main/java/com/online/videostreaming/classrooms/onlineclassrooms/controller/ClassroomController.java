package com.online.videostreaming.classrooms.onlineclassrooms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class ClassroomController {

	@RequestMapping(value = "/video-conferencing", method = RequestMethod.GET)
	public String servicesMigration(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return "video-conferencing";

	}
	
}
