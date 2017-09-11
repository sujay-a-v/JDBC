package sujay;

import java.sql.*;
import java.util.Scanner;

/**
 * A Java MySQL DELETE example.
 * Demonstrates the use of a SQL DELETE statement against a
 * MySQL database, called from a Java program, using a
 * Java PreparedStatement.
 * 
 */

public class deleteTable {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		String url="";
		String un="";
		String pw="";
		
		try
		{
			
			url="jdbc:mysql://localhost:3306/DOCUMENT2";
			un="root";
			pw="root";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,un,pw);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from EmpsDoc");
			
			while(rs.next())  {
				int id=rs.getInt("EmpID");
				String Fname=rs.getString("Fname");
				String Lname=rs.getString("Lname");
				int Phone=rs.getInt("Phone");
				int Salary=rs.getInt("Salary");
			System.out.println(id+" "+Fname+" "+Lname+" "+Phone+" "+Salary); 
			}
			
			//creating the delete query statement
			String deleteQuery="delete from EmpsDoc where EmpID=?";
			PreparedStatement preStmt=con.prepareStatement(deleteQuery);
			
			System.out.println("enter the id number to delete");
			int del=sc.nextInt();
			preStmt.setInt(1,del);
			
			//execute the prepared statement
			preStmt.execute();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
