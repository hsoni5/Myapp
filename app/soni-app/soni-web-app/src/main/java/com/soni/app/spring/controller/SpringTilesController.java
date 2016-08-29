package com.soni.app.spring.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.soni.app.spring.bean.Candidate;
import com.soni.app.spring.bean.Person;

@Controller
public class SpringTilesController {
    
	@Value("sourceList")
	private String sourceList;
	 
	@RequestMapping(value="personHome")
	public String personHome() {
		return "personHome";
	}
	
	@RequestMapping(value="viewPeson")
	public ModelAndView viewPersons(Model model) {
		Map<String, List<Person>> persons = 
				new HashMap<String, List<Person>>();
		persons.put("persons", Person.createPersons());

		return new ModelAndView("personList", persons);
	}
	
	@RequestMapping(value = "candidate", method = RequestMethod.GET)
	   public String addStudent(@ModelAttribute("candidate")Candidate candidate, 
	   ModelMap model) {
	           
	      return "addCandidate";
	   }
	
	/*@RequestMapping(method=RequestMethod.GET)
	   public String showForm(ModelMap model){
	      User user = new User();
			        model.addAttribute("USER", user);
	
		        return "registration";
	
		    }
	*/
	
	/*
	@RequestMapping(value="addCandidate")
	public String addCandidate() {
				
		return "candidateHome";
	}
	
	@RequestMapping(value="callFeedback")
	public String callFeedback() {
				
		return "callFeedback";
	}
	
	@RequestMapping(value="editCandidate")
	public String editCandidate() {
				
		return "editCandidate";
	}
	
	@RequestMapping(value="searchCandidate")
	public String searchCandidate() {
			
		return "searchCandidate";
	}
	*/
	
}
