package AssignMent;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericLiabraries.BaseClass;
import com.crm.autodesk.elementRepository.ContactInformationPage;
import com.crm.autodesk.elementRepository.ContactPage;
import com.crm.autodesk.elementRepository.CreateContactPage;
import com.crm.autodesk.elementRepository.HomePage;

public class TC_12_CreateContact extends BaseClass
{
	@Test(groups="RegressionSuite")
	public void CreateContact12() throws Throwable 
	{
		HomePage hp = new HomePage(driver);
		hp.clickContactLnk();
		
		ContactPage c = new ContactPage(driver);
		c.clickOnCreateContact();
		
		CreateContactPage ccp = new CreateContactPage(driver);
		String ContactName = eu.getExcelData("Produts",1 ,2) + jau.getrandomNum();
		ccp.enterLastName(ContactName);
		ccp.clickOnGroupRadioButton();
		ccp.selectTeamSellingFromGroupDropdown();
		ccp.clickOnSaveBtn();
		
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actualLastName = cip.lastNameValue();
		String updatetxt = cip.updateStringValue();
		System.out.println(actualLastName);
		System.out.println(updatetxt);
	}
}
