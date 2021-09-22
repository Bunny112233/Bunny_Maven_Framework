package AssignMent;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericLiabraries.BaseClass;
import com.crm.autodesk.elementRepository.ContactPage;
import com.crm.autodesk.elementRepository.HomePage;

public class TC_16_View_Contact extends BaseClass
{
	@Test
	public void View_Contact() throws Throwable 
	{		
		HomePage hp = new HomePage(driver);
		hp.clickContactLnk();
		
		ContactPage c = new ContactPage(driver);
		c.clickonLastViewd();
		
		c.fetchAllDropDownList();
	}
}
