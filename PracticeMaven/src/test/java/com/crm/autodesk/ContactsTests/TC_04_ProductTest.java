package com.crm.autodesk.ContactsTests;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericLiabraries.ExcelFileUtility;
import com.crm.autodesk.GenericLiabraries.JSONFileUtility;
import com.crm.autodesk.GenericLiabraries.JavaUtility;
import com.crm.autodesk.GenericLiabraries.WebDriverUtility;

public class TC_04_ProductTest 
{	
	WebDriver driver = null;
	@Test
	public void CreateContactWithOrganization() throws Throwable
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
		String partNumber = eu.getExcelData("Produts", 1, 3);
		
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
		
		driver.findElement(By.linkText("Products")).click();
		
		driver.findElement(By.cssSelector("img[title='Create TC_04_ProductTest...']")).click();
		driver.findElement(By.cssSelector("[name='productname']")).sendKeys(productName);
		driver.findElement(By.cssSelector("[name='productcode']")).sendKeys(partNumber);
		
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		String actual = driver.findElement(By.xpath("(//td[@class='dvtCellInfo'])[2]")).getText();
		System.out.println(actual);
		
		driver.findElement(By.linkText("Products")).click();

		driver.findElement(By.cssSelector("[name='search_text']")).sendKeys(partNumber);
		
		WebElement a = driver.findElement(By.xpath("(//select[@name='search_field'])[1]"));
		wlib.select(a, "Part Number");
		
		driver.findElement(By.xpath("(//input[@class='crmbutton small create'])[1]")).click();
		
		//String result = driver.findElement(By.xpath("//tr[@bgcolor='white']/td[2]")).getText();
		
		//WebElement b = driver.findElement(By.xpath("//table[@class='layerPopupTransport']//td[@class='small']"));
		//WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOf(b));
		//System.out.println(result);
		Thread.sleep(2000);
		//List<WebElement> abc = driver.findElements(By.xpath("//tr[@bgcolor='white']/td[2]"));
		
		List<WebElement> abc = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]"));
		//tr[@bgcolor='white']/td[2]
		
		for(WebElement s : abc)
		{
			String ss = s.getText();
			System.out.println(ss);
			if(actual.equalsIgnoreCase(ss))
			{
				System.out.println("test script pass");
			}
		}
		
		Thread.sleep(5000);
		WebElement signout = driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td[1]/img"));
		wlib.mouseover(driver, signout);
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();
	}
}
