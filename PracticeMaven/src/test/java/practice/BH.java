package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class BH {

	public static void main(String[] args) throws Throwable 
	{
		Driver driverRef = new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
		
		Statement stat = con.createStatement();
		String query = null;
		int g = 12;
		char d = 'a';
		for(int j = 1 ; j<=5 ; j++) 
		{
			query = "insert into students_info (regno, firstname, middlename, lastname) values('1', 'tu','mera', 'bhai');";
			g++;
		}
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
