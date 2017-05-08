package com.company.iservlet.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String countryCode = req.getParameter("countryCode");
		
		System.out.println("countryCode:----------------"+countryCode);
		
		resp.setContentType("text/html");
		resp.getWriter().write("Hello World!");
		
	}
}
