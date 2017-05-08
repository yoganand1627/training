package com.company.iservlet.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.iservlet.model.User;
import com.company.iservlet.service.UserService;
import com.company.iservlet.service.impl.UserServiceImpl;

public class RegistrationServlet extends HttpServlet {
	
	public void init() throws ServletException {
		System.out.println("public void init() throws ServletException::::::::"+this.getClass().getName());
		super.init();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
		
		System.out.println("protected void doGet(HttpServletRequest req, HttpServletResponse resp)");
		req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);//4: Create JSP & mention it here...
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		UserService userService = new UserServiceImpl();
		User newUser = new User();
		
		newUser.setFirstName(req.getParameter("firstName"));
		newUser.setLastName(req.getParameter("lastName"));
		newUser.setEmailId(req.getParameter("emailId"));
		newUser.setPassword(req.getParameter("password"));
		newUser.setGender(req.getParameter("gender"));
		
		String message = userService.create(newUser);
		
		
		System.out.println(req.getParameter("firstName"));
		
	}
}