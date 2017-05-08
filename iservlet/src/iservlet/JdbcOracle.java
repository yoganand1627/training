/**To retreive data form Oracle Database
 * 
 */
package iservlet;

import java.sql.*;

/**
 * @author Suneil
 *
 */
public class JdbcOracle {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		// Driver download
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		 // Connection to the database
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:sample","system","root");
		
		//SQL Statement
		Statement stmt=con.createStatement();
		
		//Executing statement
		ResultSet res=stmt.executeQuery("select * from salespeople");
		
		try

	       {
			JdbcOracle.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			String url = "jdbc:odbc:employee_dsn";
	        Connection con1 = DriverManager.getConnection(url);
			Statement stmt1 = con1.createStatement();
	        ResultSet rs = stmt1.executeQuery("Select * from emp_table");
		}
	    	catch (Exception e)
		{	
	            System.out.println(e);
	    	}
	  }

	private static Class forName(String string) {
		// TODO Auto-generated method stub
		return null;
	}
		//close connection
		con.close();
	}

