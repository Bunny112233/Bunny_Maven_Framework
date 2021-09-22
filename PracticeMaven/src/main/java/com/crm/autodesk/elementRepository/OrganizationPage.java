package com.crm.autodesk.elementRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgImg;
	
	public WebElement getCreateOrgImg() 
	{
		return createOrgImg;
	}

	public void clickOnCreateOrg()
	{
		createOrgImg.click();
	}
	
	public String HoverMsg()
	{
		String hmsg =createOrgImg.getAttribute("title");
		return hmsg;
	}
	
	@FindBy (name = "search_text")
	private WebElement searchEdt;
	
	public WebElement getSearchEdt() 
	{
		return searchEdt;
	}

	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	public WebElement getSubmitBtn() 
	{
		return submitBtn;
	}
}
