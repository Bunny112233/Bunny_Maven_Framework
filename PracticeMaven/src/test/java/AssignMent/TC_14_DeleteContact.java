package AssignMent;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericLiabraries.BaseClass;
import com.crm.autodesk.elementRepository.ContactPage;
import com.crm.autodesk.elementRepository.HomePage;

public class TC_14_DeleteContact extends BaseClass
{
	@Test(groups="SmokeSuite")
	public void DeleteContact14() throws Throwable 
	{		
		HomePage hp = new HomePage(driver);
		hp.clickContactLnk();
		
		ContactPage c = new ContactPage(driver);
		c.clickOnFirstRowChechBox();
		c.clickOnFirstRowDelLnk();
		
		String a = wlib.getMsgAlert(driver);
		System.out.println(a);
		wlib.acceptAlert(driver);	
	}
}
