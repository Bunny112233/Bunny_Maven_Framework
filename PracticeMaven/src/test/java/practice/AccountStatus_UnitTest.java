package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class AccountStatus_UnitTest 
{
	
	@Test
	public void testAccountType() throws Throwable 
	{
		Connection con = null;
		try
		{
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Accounts", "root", "root");
			
			Statement stat = con.createStatement();
			String query = "select * from Accounts";
			
			ResultSet result = stat.executeQuery(query);
			
			while(result.next()) 
			{	
				int acctnum = result.getInt("accno");
				System.out.println(acctnum);
				if(acctnum==420 && result.getString("accounttype").equals("gold")) 
				{
					System.out.println("acc type is gold & verify == pass");
					break;
				}				
				System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t" + result.getString(4));
			}
		}
		catch(Exception e) 
		{
			System.out.println("fail");	
		}
		finally 
		{
			con.close();
		}
	}

}
