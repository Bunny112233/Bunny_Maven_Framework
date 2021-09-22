package AssignMent;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLiabraries.BaseClass;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.OrganizationInfoPage;

//@Listeners(com.crm.autodesk.GenericLiabraries.Listners.class)
public class Arun1 extends BaseClass
{
	@Test
	public void CreateContact() throws Throwable 
	{
		HomePage hp = new HomePage(driver);
		hp.clickOrgLnk();
		String ContactName = eu.getExcelData("Produts",1 ,2) + jau.getrandomNum();
		CreateOrganizationPage cc = new CreateOrganizationPage(driver);
		cc.clickOnCreateOrg();
		cc.enterOrgName(ContactName);
		
		cc.clickOnEmailOPcheckbox();
		cc.checkItIsEnabledorNot();
		cc.clickOnSave();
		OrganizationInfoPage oi = new OrganizationInfoPage(driver);
		oi.waitforupdate(driver);
		
		
		
	}

}
