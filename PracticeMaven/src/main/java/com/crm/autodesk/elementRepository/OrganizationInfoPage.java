package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLiabraries.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility
{
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Locate all web element
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationInfo;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industryInfo;

	public WebElement getOrganizationInfo() 
	{
		return organizationInfo;
	}

	public WebElement getIndustryInfo() 
	{
		return industryInfo;
	}
	
	public void getOrganizationInfo1()
	{
		industryInfo.getText();
	}
	
	@FindBy(xpath = "//span[contains(text(),'Updated')]")
	private WebElement waitforupdate;

	public WebElement getWaitforupdate() 
	{
		return waitforupdate;
	}
	
	public void waitforupdate(WebDriver driver)
	{
		waitElementToBeVisible(driver, waitforupdate);
	}
	
	
}
