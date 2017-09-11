package sujay;

import java.sql.*;
public class JdbcExp {

	public static void main(String[] args) {
		
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
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
