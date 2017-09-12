package jdbc.prgms;

import java.sql.*;
public class insertTable {

	public static void main(String[] args) {
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/DOCUMENT2","root","root");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();
			stmt.executeUpdate("INSERT INTO EmpsDoc " + "VALUES (03, 'Bhushan', 'Mr.', 21087, 12000)");
			stmt.executeUpdate("INSERT INTO EmpsDoc " + "VALUES (04, 'Yogananda', 'Mr.', 96110, 16000)");

			ResultSet rs=stmt.executeQuery("select * from EmpsDoc");  
			while(rs.next())  {
				int id=rs.getInt("EmpID");
				String Fname=rs.getString("Fname");
				String Lname=rs.getString("Lname");
				int Phone=rs.getInt("Phone");
				int Salary=rs.getInt("Salary");
				System.out.println(id+" "+Fname+" "+Lname+" "+Phone+" "+Salary); 
			}
			
			con.close(); 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
