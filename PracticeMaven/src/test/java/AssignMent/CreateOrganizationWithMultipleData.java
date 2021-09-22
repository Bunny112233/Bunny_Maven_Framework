package AssignMent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericLiabraries.BaseClass;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.OrganizationInfoPage;

public class CreateOrganizationWithMultipleData extends BaseClass
{
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		return eu.getExcelData("Demo");
	}
	
	@Test(dataProvider = "getData")
	public void CreateOrganizationWithMultiple(String OrgName, String IndType) throws Throwable
	{
		HomePage hp = new HomePage(driver);
		hp.clickOrgLnk();
		
		CreateOrganizationPage cc = new CreateOrganizationPage(driver);
		cc.clickOnCreateOrg();
		cc.createOrganizationWithIndustry(OrgName+jau.getrandomNum(), IndType);
		
		OrganizationInfoPage oi = new OrganizationInfoPage(driver);
		oi.waitforupdate(driver);
		System.out.println(OrgName);
	}
}
