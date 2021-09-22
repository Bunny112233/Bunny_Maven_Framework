package AssignMent;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericLiabraries.BaseClass;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.OrganizationPage;

public class HoverVtiger 
{
	public class Arun1 extends BaseClass
	{
		@Test
		public void CreateContact() throws Throwable 
		{
			HomePage hp = new HomePage(driver);
			hp.clickOrgLnk();
			OrganizationPage jj = new OrganizationPage(driver);
			String msg = jj.HoverMsg();
			System.out.println(msg);
		}
	}
}
