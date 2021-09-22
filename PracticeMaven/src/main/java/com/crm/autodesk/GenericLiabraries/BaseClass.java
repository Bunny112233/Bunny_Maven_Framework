package com.crm.autodesk.GenericLiabraries;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;

public class BaseClass 
{
	public JSONFileUtility jsu = new JSONFileUtility();
	public JavaUtility jau = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public ExcelFileUtility eu = new ExcelFileUtility();
	public DataBaseUtility dlib = new DataBaseUtility();
	public WebDriver driver;
	public static WebDriver staticdriver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void ConnectionDB() throws Throwable
	{
		//dlib.connectToDB();
		System.out.println("Make DB connection");
	}
	
	//@Parameters("Browser")
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void launchBrowser() throws Throwable 
	{
		System.out.println("Launching browser");
		String BROWSER = jsu.readDataFromJSON("browser");
		String URL = jsu.readDataFromJSON("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		else
		{
			System.out.println("invalid browser");
		}
		
		wlib.waitForPageLoad(driver);
		wlib.maximizeWindow(driver);
		driver.get(URL);
		staticdriver = driver;
	}

	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void login() throws Throwable 
	{
		System.out.println("Log in to Application");
		
		String USERNAME = jsu.readDataFromJSON("username");
		String PASSWORD = jsu.readDataFromJSON("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}

	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void logout() 
	{
		System.out.println("Log out of Application");
		HomePage hp = new HomePage(driver);
		hp.signOut(driver);		
	}

	@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	public void closeBrowser() 
	{
		System.out.println("Closing browser");
		driver.close();
	}
	
	@AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void closeDB() throws Throwable
	{
		//dlib.closeDB();
		System.out.println("Close DB connection");
	}
	
	public String getscreenshot(String name) throws IOException
	{
		File srcfile = ((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile = System.getProperty("user.dir")+"/Screenshots/"+name+jau.getrandomNum()+".png";
		File finaldest = new File(destfile);
		FileUtils.copyFile(srcfile, finaldest);
		
		return destfile;
	}
}
