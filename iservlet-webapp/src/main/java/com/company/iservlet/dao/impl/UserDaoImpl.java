package com.company.iservlet.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.company.iservlet.dao.UserDao;
import com.company.iservlet.model.User;

public class UserDaoImpl implements UserDao{

	@Override
	public String create(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteByUserId(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User view(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String authentication(String emailId, String password) {
		String message = null;

		try{
			String sqlQuery = "SELECT COUNT(EMAIL_ID) FROM USER WHERE EMAIL_ID = ? AND PASSWORD = ?";//SQL Query
			Connection con = getConnection();//Gettting connection to the data base using this method. Common code
			PreparedStatement ps = con.prepareStatement(sqlQuery);//Pointing the java to load this sql query and 
			//make ready for the execution process.
			ps.setString(1, emailId);//Setting the valies for the ? in the sql query. first ? represent 1 = email id
			ps.setString(2, password);//? 2 = password
			
			ResultSet rs = ps.executeQuery();//Execution of query happens here
			
			if(rs.next()){//Records Exists
				
				int count = rs.getInt(1);
				
				if(count == 1){
					message = "SUCCESS";
				} else {
					message = "INVALID_EMAILID_OR_PASSWORD";
				}
			}

		}catch(Exception exe){
			message = "INTERNAL_SERVER_ERROR";
		}
		
		return message;
	}

	@Override
	public List<User> findUserByCriteria(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	private static String url = "jdbc:mysql://localhost:3306/";//Server name or server ip address
	private static String db = "sample";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String pass = "system";

	public static Connection getConnection() throws SQLException, Exception {
		//THis is common
		Class.forName(driver).newInstance();
		Connection connection = DriverManager.getConnection(url+db, user, pass);
		return connection;
	}

}
