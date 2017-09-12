package jdbc.prgms;

import java.util.*;
import java.sql.*;
public class update_table {

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
			Statement stmt=con.createStatement();
			String editSQL="Update Emps set f_name=? where Emp_id=1003";
			PreparedStatement ps=con.prepareStatement(editSQL);
			System.out.println("enter the name ");
			String name=sc.nextLine();
			ps.setString(1,name);
			ps.execute();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
