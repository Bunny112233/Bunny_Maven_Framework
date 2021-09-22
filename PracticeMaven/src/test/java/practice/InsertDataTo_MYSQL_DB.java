package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataTo_MYSQL_DB {

	public static void main(String[] args) throws Throwable 
	{
		Driver driverRef = new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
		
		Statement stat = con.createStatement();
		
		String query = "insert into students_info (regno, firstname, middlename, lastname) values('11', 'tu','mera', 'bhai');";
		
		int result = stat.executeUpdate(query);
		
		if(result==1)
		{
			System.out.println("user is created");
		}
		else
		{
			System.out.println("user is not created");
		}
		
		con.close();
	}
}
