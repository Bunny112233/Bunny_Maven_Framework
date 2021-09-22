package com.crm.autodesk.elementRepository;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//click on create contact
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactImg;

	public WebElement getCreateContactImg() 
	{
		return createContactImg;
	}
	
	public void clickOnCreateContact() 
	{
		createContactImg.click();
	}
	
	//clickMultipleCheckbox
	@FindBys({@FindBy(xpath = "//tr[@bgcolor='white']/td[1]")})
	private List<WebElement> chechBox;

	@FindBy(xpath = "//tr[@bgcolor='white']/td[1]")
	private List<WebElement> chechBox1;
	
	

	public List<WebElement> getChechBox1() {
		return chechBox1;
	}

	public void clickWithMultiCheckbox(int a,int b)
	{
		List<WebElement> list = chechBox1;
		for(WebElement s : list)
		{
			if(i==a^i==b) 
			{
				s.click();
			}
			i++;
		}
	}

	public <WebElements> List<WebElement> getChechBox() 
	{
		return chechBox;
	}
	
	int i = 0;
	public void clickMultipleCheckbox(int a,int b)
	{
		for(WebElement s : chechBox)
		{
			if(i==a^i==b) 
			{
				s.click();
			}
			i++;
		}
	}
	
	public void clickSingleCheckbox(int a)
	{
		firstRowchechBox.click();
	}
	
	//click on fourteen row check box
	@FindBy(xpath = "//tr[@bgcolor='white'][14]/td[1]")
	private WebElement firstRowchechBox;
	
	public WebElement getFirstRowchechBox() {
		return firstRowchechBox;
	}

	public void clickOnFirstRowChechBox()
	{
		firstRowchechBox.click();
	}
	
	//clickOnFirstRowDelLnk
	@FindBy(xpath = "//tr[@bgcolor='white'][14]/td[10]/a[text()='del']")
	private WebElement firstRowDelLnk;	
	
	public void clickOnFirstRowDelLnk()
	{
		firstRowDelLnk.click();
	}
	
	public WebElement getFirstRowDelLnk() 
	{
		return firstRowDelLnk;
	}
	
	//delete button
	@FindBy(xpath = "//input[@class='crmbutton small delete']")
	private WebElement deleteBtn;

	public WebElement getDeleteBtn() 
	{
		return deleteBtn;
	}
	
	public void clickOnDelete()
	{
		deleteBtn.click();
	}
	
	//click on edit
	@FindBy(xpath = "//tr[@bgcolor='white'][14]/td[10]/a[text()='edit']")
	private WebElement editBtn;

	public WebElement getEditBtn() 
	{
		return editBtn;
	}
	
	public void clickOnEdit()
	{
		editBtn.click();
	}
	
	//last view 
	@FindBy(xpath = "//img[@alt='Last Viewed']")
	private WebElement lastViewBtn;

	public WebElement getLastViewBtn() 
	{
		return lastViewBtn;
	}
	
	public void clickonLastViewd()
	{
		lastViewBtn.click();
	}
	
	//dropdown last viewed
	@FindBys({@FindBy(xpath = "//tr/td[@class='trackerList small'][1]")})
	private List<WebElement> listofLastView;

	public List<WebElement> getListofLastView() 
	{
		return listofLastView;
	}
	
	public String fetchAllDropDownList()
	{
		String list = null;
		for(WebElement s : listofLastView)
		{
			list = s.getText();
			System.out.println(list);
		}	
		return list;
	}
	
	//send mail button
	@FindBy(xpath = "//input[@value='Send Mail']")
	private WebElement sendMailBtn;

	public WebElement getSendMailBtn() 
	{
		return sendMailBtn;
	}
	
	public void clickOnSendMailBtn()
	{
		sendMailBtn.click();
	}
	
	//select on different window
	@FindBy(css = "[name='Select']")
	private WebElement selectBtn;

	public WebElement getSelectBtn() 
	{
		return selectBtn;
	}
	
	public void clickOnselect()
	{
		selectBtn.click();
	}
	
	//subject in compose mail
	@FindBy(css = "[name='subject']")
	private WebElement enterSubject;

	public WebElement getEnterSubject() 
	{
		return enterSubject;
	}
	
	public void EnterSubject(String Subject)
	{
		enterSubject.sendKeys(Subject);
	}
	
	//send in compose mail
	@FindBy(xpath = "//input[@value=' Send ']")
	private WebElement clickOnSendInComposeMail;

	public WebElement getClickOnSendInComposeMail() 
	{
		return clickOnSendInComposeMail;
	}
	
	public void clickOnSendInComposeMail()
	{
		clickOnSendInComposeMail.click();
	}
	
	//save button in compose mail
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement clickOnSaveInComposeMail;

	public WebElement getClickOnSaveInComposeMail() 
	{
		return clickOnSaveInComposeMail;
	}
	
	public void clickOnSaveInComposeMail()
	{
		clickOnSaveInComposeMail.click();
	}
	
	//click on first row check box
	@FindBy(xpath = "//tr[@bgcolor='white'][1]/td[1]")
	private WebElement firstRowchechBox1;
		
	public WebElement getFirstRowchechBox1() 
	{
		return firstRowchechBox;
	}

	public void clickOnFirstRowChechBox1()
	{
		firstRowchechBox1.click();
	}
}
