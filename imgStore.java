package jdbc.prgms;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;

public class imgStore {

	public static void main(String[] args) {
		String url="";
		String un="";
		String pw="";
		
		try
		{
			
			url="jdbc:mysql://localhost:3306/imgtable";
			un="root";
			pw="root";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,un,pw);
			
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into imgs values(?,?)");  

			ps.setString(1,"pic");  
			  
			FileInputStream fin=new FileInputStream("/home/bridgeit/Documents/Sujay/HTML/images/1.png");  
			ps.setBinaryStream(2,fin,fin.available());  
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");  
			          
			con.close();  
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
