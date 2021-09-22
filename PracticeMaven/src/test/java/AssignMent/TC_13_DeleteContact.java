package AssignMent;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericLiabraries.BaseClass;
import com.crm.autodesk.elementRepository.ContactPage;
import com.crm.autodesk.elementRepository.HomePage;


public class TC_13_DeleteContact extends BaseClass
{
	@Test(groups="SmokeSuite")
	public void DeleteContact13() throws Throwable 
	{
		HomePage hp = new HomePage(driver);
		hp.clickContactLnk();
		
		ContactPage c = new ContactPage(driver);
		
		//c.clickMultipleCheckbox(18,19);
		c.clickWithMultiCheckbox(18,19);
		c.clickOnDelete();
		String alertmsg = wlib.getMsgAlert(driver);
		System.out.println(alertmsg);
		wlib.acceptAlert(driver);
	}
}



/*int i = 0 ;
List<WebElement> a = driver.findElements(By.xpath("//tr[@bgcolor='white']/td[1]"));
for(WebElement s : a)
{
	if(i==2) 
	{
		s.click();
	}
	i++;
}*/