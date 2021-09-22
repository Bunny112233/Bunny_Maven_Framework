package com.crm.autodesk.elementRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.autodesk.GenericLiabraries.WebDriverUtility;

public class HomePage extends WebDriverUtility 
{
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	public WebElement getOrganizationLnk() 
	{
		return organizationLnk;
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;

	public void clickOrgLnk()
	{
		organizationLnk.click();
	}
	

	public String HoverMsg()
	{
		String hmsg =organizationLnk.getAttribute("title");
		return hmsg;
	}
	public WebElement getContactsLnk() 
	{
		return contactsLnk;
	} 
	
	public void clickContactLnk()
	{
		contactsLnk.click();
	}	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administator;

	public WebElement getAdministator() 
	{
		return administator;
	}
	
	//sign out 
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;

	public WebElement getSignOutLnk() 
	{
		return signOutLnk;
	}
	
	public void signOut(WebDriver driver)
	{
		waitElementToBeVisible(driver, administator);
		mouseover(driver, administator);
		signOutLnk.click();
	}	
}
