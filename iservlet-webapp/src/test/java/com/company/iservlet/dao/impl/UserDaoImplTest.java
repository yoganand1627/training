package com.company.iservlet.dao.impl;

import org.junit.Test;

import com.company.iservlet.dao.UserDao;

public class UserDaoImplTest {

	@Test
	public void testAuthentication(){
		
		UserDao dao = new UserDaoImpl();
		
		String message = dao.authentication("abc@fox.com", "fox");
		
		System.out.println("message:::::::::::::::"+message);
		
		String message1 = dao.authentication("abc@fox.com", "abc");
		System.out.println("message1:::::::::::::::"+message1);
	}
}
