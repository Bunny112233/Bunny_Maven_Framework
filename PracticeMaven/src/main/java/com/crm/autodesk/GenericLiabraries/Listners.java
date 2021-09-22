package com.crm.autodesk.GenericLiabraries;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listners implements ITestListener 
{
	JavaUtility j = new JavaUtility();
	
	ExtentReports reports;
	ExtentTest test;
	
	public void onStart(ITestContext context) 
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReportsSDET21/ExtentReports"+j.getrandomNum()+".html");
		
		reporter.config().setDocumentTitle("SDET21");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("BuildNo","5.1");
		reports.setSystemInfo("ENV","PRE-POD");
		reports.setSystemInfo("Platform","Windows");
		reports.setSystemInfo("Browser Version","Chrome-93");
	}

	public void onTestStart(ITestResult result) 
	{
		test = reports.createTest(result.getMethod().getMethodName());	
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		test.log(Status.SKIP, result.getMethod().getMethodName() + "is skipped");	
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
				
	}

	public void onTestFailure(ITestResult result) 
	{
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, result.getMethod().getMethodName() + "is failed");
		BaseClass baseClass = new BaseClass();
		try 
		{
				String path =baseClass.getscreenshot(result.getMethod().getMethodName());
				test.addScreenCaptureFromPath(path);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS, result.getMethod().getMethodName() + "is passed");
	
		BaseClass baseClass = new BaseClass();
		try 
		{
				String path =baseClass.getscreenshot(result.getMethod().getMethodName());
				test.addScreenCaptureFromPath(path);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void onFinish(ITestContext context) 
	{
		reports.flush();	
	}
}
