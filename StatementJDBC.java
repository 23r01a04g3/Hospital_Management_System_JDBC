package com.learnJDBC;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatementJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCMySQL","root","Shiva@011");
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM Students");
		
		while(rs.next()) {
			
			System.out.println("___________________________");
				
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String dept = rs.getString("dept");
			
			System.out.println("Student ID :"+id);
			System.out.println("Student Name :"+name);
			System.out.println("Student department :"+dept);
			
			System.out.println("___________________________");
		}
		
		rs.close();
		stmt.close();
		con.close();
	}

}
