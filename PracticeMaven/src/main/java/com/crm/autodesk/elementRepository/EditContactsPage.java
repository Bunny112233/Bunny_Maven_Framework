package com.crm.autodesk.elementRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditContactsPage 
{
	public EditContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastnameEdit;

	public WebElement getLastnameEdit() 
	{
		return lastnameEdit;
	}
	
	public void clearEditLastname()
	{
		lastnameEdit.click();
		lastnameEdit.clear();
	}
	
	public void editName(String name)
	{
		lastnameEdit.sendKeys(name);
	}
	
	
	@FindBy(css = "[class='crmButton small save']")
	private WebElement saveAfterEdit;

	public WebElement getSaveAfterEdit() 
	{
		return saveAfterEdit;
	}
	
	public void clickOnSaveBtnAfterEditlastName()
	{
		saveAfterEdit.click();
	}
}
