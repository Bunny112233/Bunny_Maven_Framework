package com.crm.autodesk.GenericLiabraries;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility 
{
	//this method reads data from properties file
	public String getPropertyFileData(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.PropertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
}
