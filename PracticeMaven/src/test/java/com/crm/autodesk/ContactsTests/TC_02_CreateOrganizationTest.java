package com.crm.autodesk.ContactsTests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericLiabraries.ExcelFileUtility;
import com.crm.autodesk.GenericLiabraries.JSONFileUtility;
import com.crm.autodesk.GenericLiabraries.JavaUtility;
import com.crm.autodesk.GenericLiabraries.WebDriverUtility;

public class TC_02_CreateOrganizationTest 
{
	WebDriver driver = null;
	@Test
	public void CreateContactWithOrganization() throws Throwable
	{
		//System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		JSONFileUtility jsu = new JSONFileUtility();
		JavaUtility jau = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		ExcelFileUtility eu = new ExcelFileUtility();
		
		String BROWSER = jsu.readDataFromJSON("browser");
		String URL = jsu.readDataFromJSON("url");
		String USERNAME = jsu.readDataFromJSON("username");
		String PASSWORD = jsu.readDataFromJSON("password");
		
		String contactName = eu.getExcelData("Contacts",1 ,2);
		String OrgName = eu.getExcelData("Contacts", 1, 2);
		
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
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		driver.findElement(By.cssSelector("[name='accountname']")).sendKeys("bhvinn");

		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		Thread.sleep(5000);
		WebElement signout = driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td[1]/img"));
		wlib.mouseover(driver, signout);
		driver.findElement(By.linkText("Sign Out")).click();
	}
}
		//driver.findElement(By.s("//img[@title='Select']")).click();
		//wlib.switchToWindowMain(driver);//, "Accounts");
		//wlib.switchToWindow(driver);
		//driver.findElement(By.cssSelector("input[name='search_text']")).sendKeys("good");
		//driver.findElement(By.name("search")).click();
		//driver.findElement(By.linkText("gooduivtiger")).click();