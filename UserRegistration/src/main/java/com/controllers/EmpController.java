package com.controllers;   
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beans.User;

@Controller  
public class EmpController { 
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	  public String init(Model model) {
	    model.addAttribute("msg", "Please Enter Your Login Details");
	    return "register";
	  }

	  @RequestMapping(method = RequestMethod.POST)
	  public String submit(Model model, @ModelAttribute("user") User user) {
	    if (user != null && user.getFirstname() != null & user.getPassword() != null) {
	        model.addAttribute("username", "username: " + user.getUsername());
	        model.addAttribute("password", "password:" + user.getPassword());
	        model.addAttribute("firstname","firstname: " + user.getFirstname());
	        model.addAttribute("lastname","lastname: " + user.getLastname());
	        model.addAttribute("address","Address: " + user.getAddress());
	        model.addAttribute("email", "Email: " + user.getEmail());
	        model.addAttribute("phone",  " phone: " + user.getPhone());
	        return "success";
	      } 
	    else {
	        model.addAttribute("error", "Invalid Details");
	        return "register";
	      }
	    
	  }
  
}  