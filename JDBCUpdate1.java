package com.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;	
import java.sql.Statement;

public class JDBCUpdate1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
	
		
		String URL = "jdbc:mysql://localhost:3306/JDBCMySQL";
		
		String Username = "root";
		String Passward = "Venky@007";
		
		String UpdateRecord = "UPDATE Students SET Name = 'Ram' WHERE id=2";
		
		try {
			Class.forName("com.mysql.jdbc.driver");
		}catch(ClassNotFoundException e)
		{
			System.out.println("In catch"+e.getMessage());
		}
		try {
			
			con = DriverManager.getConnection(URL,Username,Passward);
			
			stmt = con.createStatement();
			
			stmt.execute(UpdateRecord);
			
			System.out.println("Successfully Updated");
			
			stmt.close();
			con.close();
		}catch(SQLException e) 
		{
			System.out.println("In catch"+e.getMessage());
		}
		
		finally {
			if(con!=null) {
				try {
					stmt.close();
					con.close();
					
					System.out.println("Terminated Successfully");
				}catch(Exception e) {
					System.out.println("Oops! some serious issue");
				}
			}
		}
		

	}

}
