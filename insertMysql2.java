package sujay;

import java.sql.*;
import java.util.*;

import com.mysql.jdbc.PreparedStatement;
public class insertMysql2 {

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
			//Statement stmt=con.createStatement();
			
			//mySQL insert statement
			String add="insert into EmpsDoc(EmpID,Fname,Lname,Phone,Salary)"+"values(?,?,?,?,?)";
			
			PreparedStatement preStmt = (PreparedStatement) con.prepareStatement(add);
			char c;
			while(true)
			{
				System.out.println("to be continue press y else press n");
				c=sc.next().charAt(0);
				if(c=='n' || c=='N')
				{
					break;
				}
				
				System.out.println("enter the id");
				int newID=sc.nextInt();
				System.out.println("enter the first name");
				String fname=sc.next();
				System.out.println("enter the last name");
				String lname=sc.next();
				System.out.println("enter the phone number");
				int ph=sc.nextInt();
				System.out.println("enter the salary");
				int salary=sc.nextInt();
				
				preStmt.setInt(1,newID);
				preStmt.setString(2,fname);
				preStmt.setString(3,lname);
				preStmt.setInt(4,ph);
				preStmt.setInt(5,salary);	
			}
			preStmt.execute();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
