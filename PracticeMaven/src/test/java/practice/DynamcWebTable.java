package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.autodesk.GenericLiabraries.JSONFileUtility;

public class DynamcWebTable {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver;
		
		JSONFileUtility jf = new JSONFileUtility();
		
		String BROWSER 	= jf.readDataFromJSON("browser");
		String URL	   	= jf.readDataFromJSON("url");
		String USERNAME = jf.readDataFromJSON("username");
		String PASSWORD = jf.readDataFromJSON("password");
		
		
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
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.get(URL);
		
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.cssSelector("[id='submitButton']")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
		
		int count = 0 ;
		for(WebElement s : list)
		{
			if(count==0)
			{
				s.click();
			}
			if(count==10)
			{
				s.click();
			}
			count++;
		}
			
		//driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[12]/td[1]/input")).click();
		
		Thread.sleep(10000);
		driver.close();
		
		
	}
}
