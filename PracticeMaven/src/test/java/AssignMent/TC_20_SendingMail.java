package AssignMent;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericLiabraries.BaseClass;
import com.crm.autodesk.elementRepository.ContactPage;
import com.crm.autodesk.elementRepository.HomePage;

public class TC_20_SendingMail extends BaseClass
{
	@Test
	public void CreateContact() throws Throwable 
	{
		HomePage hp = new HomePage(driver);
		hp.clickContactLnk();
		
		ContactPage c = new ContactPage(driver);
		c.clickMultipleCheckbox(0, 1);
		c.clickOnSendMailBtn();
		c.clickOnselect();
		wlib.switchToWindow(driver, "Emails");
		String Subject = eu.getExcelData("Produts",1 ,2) + jau.getrandomNum();
		c.EnterSubject(Subject);
		c.clickOnSaveInComposeMail();
		wlib.switchToWindow(driver, "Emails");
	}
}
