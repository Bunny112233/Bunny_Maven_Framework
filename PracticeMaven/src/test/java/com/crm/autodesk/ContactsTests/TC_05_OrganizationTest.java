package com.crm.autodesk.ContactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLiabraries.ExcelFileUtility;
import com.crm.autodesk.GenericLiabraries.JSONFileUtility;
import com.crm.autodesk.GenericLiabraries.JavaUtility;
import com.crm.autodesk.GenericLiabraries.WebDriverUtility;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;

public class TC_05_OrganizationTest 
{
	WebDriver driver;
	@Test
	public void OrganizationTest() throws Throwable 
	{
		JSONFileUtility jsu = new JSONFileUtility();
		JavaUtility jau = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		ExcelFileUtility eu = new ExcelFileUtility();
		
		String BROWSER = jsu.readDataFromJSON("browser");
		String URL = jsu.readDataFromJSON("url");
		String USERNAME = jsu.readDataFromJSON("username");
		String PASSWORD = jsu.readDataFromJSON("password");
		
		String productName = eu.getExcelData("Produts",1 ,2);
		String OrgName = eu.getExcelData("Produts", 1, 2);
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		wlib.waitForPageLoad(driver);
		wlib.maximizeWindow(driver);
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		
		
		HomePage hp = new HomePage(driver);
		System.out.println("pass");
		driver.close();
		
	}
}
