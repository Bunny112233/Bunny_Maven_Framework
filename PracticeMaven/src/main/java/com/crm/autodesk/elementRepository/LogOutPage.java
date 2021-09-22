package com.crm.autodesk.elementRepository;
import org.openqa.selenium.WebDriver;
public class LogOutPage 
{
	WebDriver driver;

	public void logout()
	{
		driver.quit();
	}
}
