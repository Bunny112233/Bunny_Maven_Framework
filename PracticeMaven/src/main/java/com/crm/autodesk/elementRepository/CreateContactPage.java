package com.crm.autodesk.elementRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLiabraries.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility
{

	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastName;
	
	public WebElement getLastName() 
	{
		return lastName;
	}
	
	public void enterLastName(String lastname)
	{
		lastName.sendKeys(lastname);
	}
	
	@FindBy(css = "[class='crmButton small save']")
	private WebElement saveBtn;
	
	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}
	
	public void clickOnSaveBtn()
	{
		saveBtn.click();
	}

	@FindBy(name = "assigned_group_id")
	private WebElement groupDropdown;
	
	public WebElement getGroupDropdown() 
	{
		return groupDropdown;
	}
	
	public void selectMarketingGroupFromGroupDropdown()
	{
		select(groupDropdown, "Marketing Group");
	}
	
	public void selectSupportGroupFromGroupDropdown()
	{
		select(groupDropdown, "Support Group");
	}
	
	public void selectTeamSellingFromGroupDropdown()
	{
		select(groupDropdown, "Team Selling");	
	}
	
	@FindBy(css = "[value='T']")
	private WebElement groupRadioBtn;
	
	public WebElement getGroupRadioBtn() 
	{
		return groupRadioBtn;
	}
	
	public void clickOnGroupRadioButton() 
	{
		groupRadioBtn.click();
	}
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[2]")
	private WebElement clickreortTo;

	public WebElement getClickreortTo() 
	{
		return clickreortTo;
	}
	
	public void clickOnreport()
	{
		clickreortTo.click();
	}
	
	@FindBy(xpath = "//a[text()='Mary Smith']")
	private WebElement clickonlinktxt;

	public WebElement getClickonlinktxt() 
	{
		return clickonlinktxt;
	}
	
	public void clickonlinktxt()
	{
		clickonlinktxt.click();
	}
}
