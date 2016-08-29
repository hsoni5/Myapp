package com.soni.app.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProfileController {

	@RequestMapping(value="/addProfile", method = RequestMethod.GET)
	public ModelAndView addProfile() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		return new ModelAndView("addProfile", model);
	}
	
	@RequestMapping(value="/showProfile", method = RequestMethod.GET)
	public ModelAndView showProfile() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		return new ModelAndView("showProfile", model);
	}
   
	@RequestMapping(value="/editProfile", method = RequestMethod.GET)
	public ModelAndView editProfile() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		return new ModelAndView("editProfile", model);
	}	
	
	
}
