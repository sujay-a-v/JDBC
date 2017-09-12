package jdbc.prgms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

public class DBmetadata {

	public static void main(String[] args) {
		

		String url="";
		String un="";
		String pw="";
		
		try
		{
			
			url="jdbc:mysql://localhost:3306/EmpDB";
			un="root";
			pw="root";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,un,pw);
			DatabaseMetaData dbmd=(DatabaseMetaData) con.getMetaData();
			
			System.out.println("Driver name: "+dbmd.getDriverName());
			System.out.println("Driver Verson: "+dbmd.getDriverVersion());
			System.out.println("User name: "+dbmd.getUserName());
			System.out.println("Database product name: "+dbmd.getDatabaseProductName());
			System.out.println("Database product Verson: "+dbmd.getDatabaseProductVersion());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
