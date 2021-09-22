package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Sample_MavenParameterTest {
	
	@Test
	public void sampleTest(){
		
		System.out.println("excute Test");
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
		driver.close();
	}

}
