package com.company.iservlet.service;

import java.util.List;

import com.company.iservlet.model.User;

public interface UserService {//1

	public User update(User user);
	
	public String create(User user);
	
	public User viewByUserId(long userId);
	
	public User viewByEmailId(String emailId);
	
	public String delete(long userId);
	
	public String authentication(String emailId, String password);//2
	
	public List<User> getAllUsers();
	
	public List<User> search();

	
	
	
}
