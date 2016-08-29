package com.soni.app.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soni.app.spring.bean.User;
import com.soni.app.spring.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService ps){
		this.userService = ps;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.findAllUsers());
		return "users";
	}
	
	//For add and update User both
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user){
		
		if(user.getId() == 0){
			//new User, add it
			this.userService.saveUser(user);;
		}else{
			//existing User, call update
			this.userService.updateUser(user);
		}
		
		return "redirect:/users";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
		
        this.userService.deleteUserById(id);
        return "redirect:/users";
    }
 
    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model){
        model.addAttribute("user", this.userService.findById(id));
        model.addAttribute("listUsers", this.userService.findAllUsers());
        return "user";
    }
	
    @RequestMapping(value = "/userHome", method = RequestMethod.GET)
	public String candidate(Model model) {
    	
		return "user";
	}
    
    
}
