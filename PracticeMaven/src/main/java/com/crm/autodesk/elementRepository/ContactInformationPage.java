package com.crm.autodesk.elementRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage 
{
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[class='dvHeaderText']")
	private WebElement lastName;
	
	public WebElement getLastName() 
	{
		return lastName;
	}
	
	public String lastNameValue()
	{
		return lastName.getText();
	}
	
	@FindBy(xpath = "//span[contains(text(),'Updated today')]")
	private WebElement updatetodaytext;

	public WebElement getUpdatetodaytext() 
	{
		return updatetodaytext;
	}
	
	public String updateStringValue()
	{
		return updatetodaytext.getText();
	}
}
