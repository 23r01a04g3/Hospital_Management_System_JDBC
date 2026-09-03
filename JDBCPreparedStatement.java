package com.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPreparedStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		//Statement stmt = null;
		ResultSet rs = null;
		
		String URL = "jdbc:mysql://localhost:3306/JDBCMySQL";
		
		String Username = "root";
		String Passward = "Venky@007";
		
		String Query = "SELECT * FROM Students WHERE Name = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded !");
		}catch(ClassNotFoundException e) {
			System.out.println("Drivers not loaded");
			System.out.println("In catch"+e.getMessage());
		}
		
		try {
			con = DriverManager.getConnection(URL,Username,Passward);
			
			PreparedStatement preparedStatement = con.prepareStatement(Query);
			preparedStatement.setString(1, "Gita");
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				System.out.println("_______________________");
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String dept = rs.getString("dept");
				
				System.out.println("Student ID : "+id);
				System.out.println("Student Name : "+name);
				System.out.println("Student Department : "+dept);
				
				System.out.println("_________________________");
				
			}
			rs.close();
			//stmt.close();
			con.close();
		}catch(SQLException e)
		{
			System.out.println("In catch"+e.getMessage());
		}
		
		finally {
			if(con != null) {
				try {
					rs.close();
					//stmt.close();
					con.close();
					
					System.out.println("Terminated Successfully");
				}catch(Exception e) 
				{
					System.out.println("Oops! some serious issue");
				}
			}
		}
	}

}
