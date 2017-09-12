package jdbc.prgms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class curdop {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		String url="";
		String un="root";
		String pw="root";
		int n;
		
		try
		{
			url="jdbc:mysql://localhost:3306/EmpDB";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,un,pw);
			Statement stmt=(Statement) con.createStatement();
			
			while(true)
			{
				System.out.println("press 1 for insert");
				System.out.println("press 2 for remove");
				System.out.println("press 3 for update");
				System.out.println("press 4 for Ascending order");
				System.out.println("press 5 for Decending order");
				System.out.println("press 6 for display");
				System.out.println("press 0 for exit");

				System.out.println("enter your choice");
				n=scan.nextInt();
				
				if(n==1)
				{
					//mySQL insert statement
					String add="insert into Emps(Emp_id,f_name,l_name,Ph,Sal)"+"values(?,?,?,?,?)";
					
					PreparedStatement preStmt = (PreparedStatement) con.prepareStatement(add);
					char c;
					while(true)
					{
						System.out.println("to be continue press y else press n");
						c=scan.next().charAt(0);
						if(c=='n' || c=='N')
						{
							break;
						}
						
						System.out.println("enter the id");
						int newID=scan.nextInt();
						System.out.println("enter the first name");
						String fname=scan.next();
						System.out.println("enter the last name");
						String lname=scan.next();
						System.out.println("enter the phone number");
						int ph=scan.nextInt();
						System.out.println("enter the salary");
						int salary=scan.nextInt();
						
						preStmt.setInt(1,newID);
						preStmt.setString(2,fname);
						preStmt.setString(3,lname);
						preStmt.setInt(4,ph);
						preStmt.setInt(5,salary);	
					}
					preStmt.execute();
					//con.close();	
				}
				
				else if(n==2)
				{
					//creating the delete query statement
					String deleteQuery="delete from Emps where Emp_id=?";
					PreparedStatement preStmt=con.prepareStatement(deleteQuery);
					
					System.out.println("enter the id number to delete");
					int del=scan.nextInt();
					preStmt.setInt(1,del);
					
					//execute the prepared statement
					preStmt.execute();
					//con.close();
				}
				
				else if(n==3)
				{
					
					String editSQL="Update Emps set f_name=?,l_name=? where Emp_id=?";
					PreparedStatement ps=con.prepareStatement(editSQL);
					System.out.println("enter the id for update");
					int id=scan.nextInt();
					ps.setInt(3, id);
					System.out.println("enter the first name ");
					String fname=scan.next();
					ps.setString(1,fname);
					System.out.println("enter the last name ");
					String lname=scan.next();
					ps.setString(2,lname);
					ps.executeUpdate();
					//con.close();
				}
				
				else if(n==4)
				{
					//Arranging rows in  ascending order by first name.
					System.out.println("Arrange the table in ascending order by first name\n");
					String asc="SELECT * FROM Emps" + " ORDER BY f_name ASC";
					
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
				}
				
				else if(n==5)
				{
					//arranging rows in descending order by last name.
					System.out.println("\nArrange the table in descending order by last name\n");

					String desc="SELECT * FROM Emps" + " ORDER BY l_name DESC";
					
					ResultSet rs=stmt.executeQuery(desc);
					while(rs.next())
					{
						int id=rs.getInt("Emp_id");
						String Fname=rs.getString("f_name");
						String Lname=rs.getString("l_name");
						int Phone=rs.getInt("Ph");
						int Salary=rs.getInt("Sal");
					System.out.println(id+" "+Fname+" "+Lname+" "+Phone+" "+Salary); 
					
					}
				}
				
				else if(n==6)
				{
					ResultSet rs=stmt.executeQuery("select * from Emps");
					while(rs.next()) 
					{
						int id=rs.getInt("Emp_id");
						String Fname=rs.getString("f_name");
						String Lname=rs.getString("l_name");
						int Phone=rs.getInt("Ph");
						int Salary=rs.getInt("Sal");
						System.out.println(id+" "+Fname+" "+Lname+" "+Phone+" "+Salary); 
					}
					System.out.println();
				}
				
				else if(n==0)
				{
					System.exit(0);
				}

				else
				{
					System.out.println("enter the correct option");
				}

			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


	}

}
