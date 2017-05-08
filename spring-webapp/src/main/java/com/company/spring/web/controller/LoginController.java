package com.company.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.spring.pojo.User;

@Controller
@RequestMapping("/user")
public class LoginController {

	@RequestMapping("/login.htm")
	public String initForm(ModelMap model){
		
		User user = new User();
		model.addAttribute("commandObject", user);
		
		return "/WEB-INF/jsp/loginSpring.jsp";

	}
	
	@RequestMapping("/auth.htm")
	public String authentication(@ModelAttribute("commandObject") User user){
		
		System.out.println("User Name:::::::::"+user.getEmailId());
		System.out.println("Password:::::::::"+user.getPassword());
		
		return "/WEB-INF/jsp/successSpring.jsp";

	}

}
