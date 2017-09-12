package jdbc.prgms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class imgRetrieve
{
	
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
			
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from imgs");  

			ResultSet rs=(ResultSet) ps.executeQuery();  
			if(rs.next())
			{//now on 1st row
				  
	              
				Blob b=(Blob) rs.getBlob(2);//2 means 2nd column data  
				byte barr[]=b.getBytes(1,(int)b.length());//1 means first image  
				              
				FileOutputStream fos=new FileOutputStream("/home/bridgeit/Documents/Sujay/HTML/images/25.png");  
				fos.write(barr);  
				              
				fos.close();  
				}//end of if  
				System.out.println("ok");  
				              

			
			              
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
