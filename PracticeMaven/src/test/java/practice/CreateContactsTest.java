package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateContactsTest {
	
	@Test
	public void createContactsTest() throws InterruptedException {
	
	String URL = System.getProperty("url");
	String username = System.getProperty("username");
	String password = System.getProperty("password");
	String browser = System.getProperty("browserName");
	
	WebDriver driver = null;
	if(browser.equals("chrome")) {
		driver = new ChromeDriver();
		
	}else if(browser.equals("firefox")) {
		driver = new FirefoxDriver();
	}

	System.out.println(URL);
	System.out.println(username);
	System.out.println(password);
	
	
	driver.get(URL);
	driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(username);
	driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(password);
	driver.findElement(By.cssSelector("[id='submitButton']")).click();
	
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys("bhavin" , Keys.ENTER);
	Thread.sleep(2000);
	driver.close();

	}
}
