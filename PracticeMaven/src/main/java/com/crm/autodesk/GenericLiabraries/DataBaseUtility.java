package com.crm.autodesk.GenericLiabraries;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.poi.util.SystemOutLogger;

import com.mysql.cj.jdbc.Driver;
public class DataBaseUtility 
{
	Connection con = null;
	ResultSet result = null;
	Driver driverRef;
	
	public void connectToDB() throws Throwable
	{
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
	}
	
	public void closeDB() throws Throwable 
	{
		con.close();
	}
	
	public String getDataFromDB(String query, int Columnindex) throws Throwable
	{
		Statement stat = con.createStatement();
		String value = "select * from students_info";
		result = con.createStatement().executeQuery(query);
		
		while(result.next()) 
		{	
			value = result.getString(Columnindex);
		}
		return value;
	}
	
	public String getDataFromDB(String query, int columnindex, String expData) throws Throwable
	{
		boolean flag = false;
		result = con.createStatement().executeQuery(query);
		while(result.next()) 
		{	
			if(result.getString(columnindex).equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData + "data verified in database");
			return expData;
		}
		else
		{
			System.out.println(expData + "data not verified");
			return expData;
		}
	}
}
