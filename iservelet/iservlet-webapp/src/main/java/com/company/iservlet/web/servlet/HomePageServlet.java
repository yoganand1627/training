package com.company.iservlet.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.iservlet.model.User;
import com.company.iservlet.service.UserService;
import com.company.iservlet.service.impl.UserServiceImpl;

public class HomePageServlet extends HttpServlet/*1*/ {

	/**
	 * Servlet Lifecycle: init
	 * service (doGet, doPost, doPut, doDelete)
	 * destroy methods.
	 */
	
	@Override
	public void init() throws ServletException {
		System.out.println("public void init() throws ServletException::::::::"+this.getClass().getName());
		super.init();
	}
	
	@Override//2
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("protected void doGet(HttpServletRequest req, HttpServletResponse resp)");
		
		req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);//4: Create JSP & mention it here...
	}
	
	@Override//3
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("protected void doPost(HttpServletRequest req, HttpServletResponse resp)");
		
		System.out.println("emailIdField::::::::::::"+req.getParameter("emailIdField"));
		System.out.println("passwordField:::::::::::"+req.getParameter("passwordField"));
		
		String emailId = req.getParameter("emailIdField");
		String password = req.getParameter("passwordField");
		
		if(true){//Validation Rules//FIXME 
			UserService userService = new UserServiceImpl();
			String message = userService.authentication(emailId, password);
			
			if("SUCCESS".equals(message)){
				
				User user = userService.viewByEmailId(emailId);
				if(user == null){
					req.setAttribute("errorMessage", "Server error. Error has been reported to adminstrator. Please try later.");
					req.getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);				
				} else {
				req.setAttribute("userObject", user);
				req.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp").forward(req, resp);
				}
			}else if("INVALID_EMAILID_OR_PASSWORD".equals(message)){
				
				req.setAttribute("errorMessage", "Invalid Email / Password.");
				req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
				
			}else if("INTERNAL_SERVER_ERROR".equals(message)){
				req.setAttribute("errorMessage", "Server error. Error has been reported to adminstrator. Please try later.");
				req.getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);				
			}
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("public void destroy() ::::::::"+this.getClass().getName());
		super.destroy();
	}
}
