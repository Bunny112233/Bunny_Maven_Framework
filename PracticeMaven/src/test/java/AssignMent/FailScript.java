package AssignMent;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericLiabraries.BaseClass;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;

@Listeners(com.crm.autodesk.GenericLiabraries.Listners.class)
public class FailScript extends BaseClass 
{
	@Test//(retryAnalyzer = com.crm.autodesk.GenericLiabraries.RetryAnalyser.class)
	public void CreateContact() throws Throwable 
	{
		CreateOrganizationPage cc = new CreateOrganizationPage(driver);
		cc.clickOnCreateOrg1();
	}
}
