package com.crm.autodesk.elementRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.autodesk.GenericLiabraries.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility
{
	public CreateOrganizationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//locate all web element
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getOrgNameEdt() 
	{
		return OrgNameEdt;
	}

	public WebElement getIndustryDropdown()
	{
		return industryDropdown;
	}

	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}
	
	//business logic
	/*
	 * this method will create organization with mandatory field
	 * @bhavin OrgName
	 */
	
	public void createOrganization(String Orgname)
	{
		OrgNameEdt.sendKeys(Orgname);
		saveBtn.click();
	}
	
	/*
	 * this method will create organization by choosing an industry
	 * @bhavin OrgName
	 */
	
	public void createOrganizationWithIndustry(String Orgname, String indType) 
	{
		OrgNameEdt.sendKeys(Orgname);
		select(industryDropdown, indType);
		saveBtn.click();
	}
	
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrg;
	
	public WebElement getCreateOrg() 
	{
		return createOrg;
	}
	
	public void clickOnCreateOrg()
	{
		createOrg.click();
	}
	
	
	@FindBy(css = "[name='accountname']")
	private WebElement enterOrgName;
	
	public WebElement getEnterOrgName() 
	{
		return enterOrgName;
	}
	
	public void enterOrgName(String value)
	{
		enterOrgName.sendKeys(value);
	}
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement clickOnMemberOf;
	
	public WebElement getClickOnMemberOf() 
	{
		return clickOnMemberOf;
	}
	
	public void clickOnMemberOf()
	{
		clickOnMemberOf.click();
	}
	
	
	@FindBy(xpath = "//a[text()='bhavin']")
	private WebElement clickOnBhavin;
	
	public WebElement getClickOnBhavin() 
	{
		return clickOnBhavin;
	}
	
	public void clickOnBhavin()
	{
		clickOnBhavin.click();
	}
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement clickOnSave;
	
	public WebElement getClickOnSave() 
	{
		return clickOnSave;
	}
	
	public void clickOnSave()
	{
		clickOnSave.click();
	}
	
	
	@FindBy(css = "[name='emailoptout']")
	private WebElement clickOnEmailOPcheckbox;
	
	public WebElement getClickOnEmailOPcheckbox() 
	{
		return clickOnEmailOPcheckbox;
	}
	
	public void clickOnEmailOPcheckbox()
	{
		clickOnEmailOPcheckbox.click();
	}
	
	@FindBy(css = "[name='emailoptout']")
	private WebElement checkItIsEnabledorNot;
	
	public WebElement getCheckItIsEnabledorNot() 
	{
		return checkItIsEnabledorNot;
	}
	
	public void checkItIsEnabledorNot()
	{
		if(checkItIsEnabledorNot.isEnabled())
		{
			System.out.println("its selected");
		}
		else
		{
			System.out.println("its not selected");
		}
	}

	@FindBy(xpath = "//img[@alt='Create Organization']")
	private WebElement createOrg1;
	
	public WebElement getCreateOrg1() 
	{
		return createOrg1;
	}
	
	public void clickOnCreateOrg1()
	{
		createOrg1.click();
	}
}
