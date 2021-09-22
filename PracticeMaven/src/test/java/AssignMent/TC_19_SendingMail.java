package AssignMent;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericLiabraries.BaseClass;
import com.crm.autodesk.elementRepository.ContactPage;
import com.crm.autodesk.elementRepository.HomePage;

public class TC_19_SendingMail extends BaseClass
{
	@Test
	public void SendingMail() throws Throwable 
	{		
		HomePage hp = new HomePage(driver);
		hp.clickContactLnk();
		
		ContactPage c = new ContactPage(driver);
		c.clickOnSendMailBtn();
		String altmsg = wlib.getMsgAlert(driver);
		wlib.acceptAlert(driver);
		System.out.println(altmsg);
	}
}
