package com.soni.app.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.soni.app.spring.core.Login;

@Controller
public class LoginController {
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView saveEmployee(@ModelAttribute("command") Login login, 
			BindingResult result) {
		return new ModelAndView("/module/employee/login");
	}

	

}
