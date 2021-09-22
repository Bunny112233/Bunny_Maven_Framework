package com.crm.autodesk.GenericLiabraries;
import java.io.FileReader;
import java.util.HashMap;
import org.json.simple.parser.JSONParser;

/* this class contains methods to read data from json file
 * @author bhavin
 */
public class JSONFileUtility 
{
	//this method reads the data from jason file	
	public String readDataFromJSON(String key) throws Throwable 
	{
		FileReader file = new FileReader("./commonData.json");	
		JSONParser jp = new JSONParser();
		Object obj = jp.parse(file);
		HashMap map = (HashMap)obj;
		String value = map.get(key).toString();
		return value;
	}
}
