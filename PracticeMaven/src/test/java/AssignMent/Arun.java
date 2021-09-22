package AssignMent;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericLiabraries.BaseClass;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.HomePage;

public class Arun extends BaseClass
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
		cc.clickOnMemberOf();
		wlib.switchToWindow(driver, "Popup");
		cc.clickOnBhavin();
		wlib.acceptAlert(driver);
		
		wlib.switchToWindow(driver, "EditView");
		cc.clickOnSave();
		Thread.sleep(5000);
	}
}
