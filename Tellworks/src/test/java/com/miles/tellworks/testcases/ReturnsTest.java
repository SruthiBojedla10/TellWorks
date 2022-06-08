package com.miles.tellworks.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.miles.tellworks.mainmenu.TellworksBase;
import com.miles.tellworks.pagepanel.CommonMethods;
import com.miles.tellworks.pagepanel.Returns;
import com.miles.tellworks.pagepanel.TellWorksLogin;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReturnsTest extends TellworksBase{

	TellWorksLogin twLogin;
	Returns returns;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ReturnsReport.html", true);			
	}
		
	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}
	
	@BeforeClass
	public void launchBrowser() {
		driverInitialization();
		twLogin = new TellWorksLogin();
		returns = new Returns();
		twLogin.login();
	}

	@Test
	public void RequestOverviewTest() throws InterruptedException {
		extentTest = extent.startTest("RequestOverviewTest");
		Assert.assertTrue(returns.ReturnsRequestOverview());
	}
	
	@Test
	public void RequestUserApproverTest() throws InterruptedException {
		extentTest = extent.startTest("RequestUserApproverTest");
		Assert.assertTrue(returns.ReturnsUserApproverAssignment());
	}
	
	@Test
	public void RequestworkflowMaintenanceTest() throws InterruptedException {
		extentTest = extent.startTest("RequestworkflowMaintenanceTest");
		Assert.assertTrue(returns.ReturnsWorkflowMaintenance());
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); 
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); 
			
			String screenshotPath = CommonMethods.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); 
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
		extent.endTest(extentTest); 
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}
}
