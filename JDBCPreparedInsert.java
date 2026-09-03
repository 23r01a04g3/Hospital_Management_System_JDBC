package com.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPreparedInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		//Statement stmt = null;
		ResultSet rs = null;
		
		String URL = "jdbc:mysql://localhost:3306/JDBCMySQL";	
		
		String Username = "root";
		String Passward = "Venky@007";
		
		String Query = "insert into students(id,name,dept) values (?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded !");
		}catch(ClassNotFoundException e) 
		{
			System.out.println("Drivers nit loaded");
			System.out.println("in catch"+e.getMessage());
			
		}
		
		try {
			con = DriverManager.getConnection(URL,Username,Passward);
			
			PreparedStatement preparedStatement = con.prepareStatement(Query);
			preparedStatement.setInt(1, 9);
			preparedStatement.setString(2, "Abhinav Bindra");
			preparedStatement.setString(3,"Biotechnology");
			
			preparedStatement.execute();
			
			con.close();
			System.out.println("Inserted Successfully");
		}catch(SQLException e) {
			System.out.println("In catch"+e.getMessage());
		}
		finally {
			if(con != null) {
				try {
					con.close();
					
					System.out.println("Terminated Successfully");
				}catch(Exception e) {
					System.out.println("Oops! some serious issue");
				}
			}
		}

	}

}
