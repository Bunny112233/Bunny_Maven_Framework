package AssignMent;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericLiabraries.BaseClass;
import com.crm.autodesk.elementRepository.ContactPage;
import com.crm.autodesk.elementRepository.EditContactsPage;
import com.crm.autodesk.elementRepository.HomePage;

public class TC_15_EditContact extends BaseClass
{
	@Test(groups="SmokeSuite")
	public void EditContact15() throws Throwable 
	{
		HomePage hp = new HomePage(driver);
		hp.clickContactLnk();
		
		ContactPage c = new ContactPage(driver);
		c.clickOnEdit();
		
		EditContactsPage e = new EditContactsPage(driver);
		String ContactName1 = eu.getExcelData("Produts",1 ,2) + jau.getrandomNum();
		e.clearEditLastname();
		e.editName(ContactName1);
		e.clickOnSaveBtnAfterEditlastName();
	}
}
