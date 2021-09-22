package practice;
import com.crm.autodesk.GenericLiabraries.JSONFileUtility;

public class DemofileReader {

	public static void main(String[] args) throws Throwable {
		
		JSONFileUtility jfu = new JSONFileUtility();
		
		String BROWSER = jfu.readDataFromJSON("browser");
		String URL = jfu.readDataFromJSON("url");
		String USERNAME = jfu.readDataFromJSON("username");
		String PASSWORD = jfu.readDataFromJSON("password");
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		
	}
}
