package com.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement stmt = null;
		//ResultSet rs = null;
		
		String URL = "jdbc:mysql://localhost:3306/JDBCMySQL";
		
		String Username = "root";
		String Passward = "Venky@007";
		
		String TableName = "CREATE TABLE Test(RollNumber INT PRIMARY KEY,Name VARCHAR(225),Marks INT Not Null,Grade VARCHAR(21))";
		
		try {
			Class.forName("com.mysql.jdbc.driver");
		}catch(ClassNotFoundException e)
		{
			System.out.println("In catch"+e.getMessage());
		}
		try {
			con = DriverManager.getConnection(URL,Username,Passward);
			
			stmt = con.createStatement();
			
			stmt.execute(TableName);
			
			System.out.println("Yay ! Table Created");
			
			//rs.close();
			stmt.close();
			con.close();
		}catch(SQLException e)
		{
			System.out.println("In catch"+e.getMessage());
		}
		
		finally {
			if(con!=null) {
				try {
					//rs.close();
					stmt.close();
					con.close();
					System.out.println("Termianted Successfully");
				}catch(Exception e)
				{
					System.out.println("Oops! Some Serious issue");
				}
			}
		}

	}

}
