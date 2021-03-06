package com.controllers;   
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beans.LoginBean;

@Controller  
public class EmpController { 
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	  public String init(Model model) {
	    model.addAttribute("msg", "Please Enter Your Login Details");
	    return "login";
	  }

	  @RequestMapping(method = RequestMethod.POST)
	  public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
	    if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
	        model.addAttribute("msg", "username: " + loginBean.getUserName() + "\n" + "password:" + loginBean.getPassword());
	        return "success";
	      } 
	    else {
	        model.addAttribute("error", "Invalid Details");
	        return "login";
	      }
	    
	  }
  
}  