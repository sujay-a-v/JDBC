package jdbc.prgms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

public class mataData {

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
			PreparedStatement preStmt=(PreparedStatement) con.prepareStatement("select * from Emps");
			ResultSet rs=preStmt.executeQuery();
			ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
			
			System.out.println("total columns : "+rsmd.getColumnCount());
			System.out.println("Name of the first column : "+rsmd.getColumnName(2));
			System.out.println("type of first column : "+rsmd.getColumnTypeName(2));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
