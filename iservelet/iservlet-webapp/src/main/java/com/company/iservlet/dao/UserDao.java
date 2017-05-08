package com.company.iservlet.dao;

import java.util.List;

import com.company.iservlet.model.User;

public interface UserDao {

	//String : SUCCESS, FAILURE, ERROR
	public String create(User user);
	
	public String update(User user);

	public String deleteByEmailId(String emailId);
	
	public String deleteByUserId(long userId);
	
	public User view(long userId);
	
	public String authentication(String emailId, String password);
	
	//Search Users
	public List<User> findUserByCriteria(User user);
	
}
