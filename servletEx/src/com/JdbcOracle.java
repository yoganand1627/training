package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JdbcOracle
 */
@WebServlet("/JdbcOracle")
public class JdbcOracle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public JdbcOracle() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("asdasd");
		PrintWriter out = response.getWriter(); 
		// Driver download
		try {		
			System.out.println("asdasd");
		Class.forName("oracle.jdbc.driver.OracleDriver");
				//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
				 // Connection to the database
		System.out.println("asdasd");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:sample","system","root");
				
				//SQL Statement
				Statement stmt=con.createStatement();
				
				//Executing statement
				ResultSet res=stmt.executeQuery("select * from salespeople");
				
				while (res.next()){
					System.out.println(res.getInt(1));
					System.out.println(res.getString(2));
					System.out.println("=========================================");
				}
				//close connection
				con.close();
		}catch(Exception e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
