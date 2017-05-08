package com.company.iservlet.service.impl;

import java.util.List;

import com.company.iservlet.model.User;
import com.company.iservlet.service.UserService;

public class UserServiceImpl implements UserService {//3

//	private UserDao userDao = null;
	public UserServiceImpl(){
//		userDao = new UserDaoImpl();
	}
	
	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String create(User newUser) {
		// TODO Auto-generated method stub
//		String message = userDao.create(newUser); 
		
		return null;
		}

	@Override
	public User viewByUserId(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User viewByEmailId(String emailId) {
//		User userDetail = userDao.viewByEmailId(emailId);
		return null;
	}

	@Override
	public String delete(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String authentication(String emailId, String password) {//4
		
//		String message = userDao.authentication(emailId, password);
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> search() {
		// TODO Auto-generated method stub
		return null;
	}


}
