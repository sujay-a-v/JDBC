package sujay;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class order_wise {

	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		String url="";
		String un="root";
		String pw="root";
		 
		try
		{
			url="jdbc:mysql://localhost:3306/EmpDB";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,un,pw);
			
			Statement stmt=(Statement) con.createStatement();
			
			//Arranging rows in  ascending order by first name.
			System.out.println("Arrange the table in ascending order by first name\n");
			String asc="SELECT Emp_id,f_name,l_name,Ph,Sal FROM Emps" + " ORDER BY f_name ASC";
			
			ResultSet rs=stmt.executeQuery(asc);
			while(rs.next())
			{
				int id=rs.getInt("Emp_id");
				String Fname=rs.getString("f_name");
				String Lname=rs.getString("l_name");
				int Phone=rs.getInt("Ph");
				int Salary=rs.getInt("Sal");
			System.out.println(id+" "+Fname+" "+Lname+" "+Phone+" "+Salary); 
			
			}
			
			//arranging rows in descending order by last name.
			System.out.println("\nArrange the table in descending order by last name\n");

			String desc="SELECT Emp_id,f_name,l_name,Ph,Sal FROM Emps" + " ORDER BY l_name DESC";
			
			 rs=stmt.executeQuery(desc);
			while(rs.next())
			{
				int id=rs.getInt("Emp_id");
				String Fname=rs.getString("f_name");
				String Lname=rs.getString("l_name");
				int Phone=rs.getInt("Ph");
				int Salary=rs.getInt("Sal");
			System.out.println(id+" "+Fname+" "+Lname+" "+Phone+" "+Salary); 
			
			}
			//con.commit();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
