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
import com.miles.tellworks.pagepanel.Receiving;
import com.miles.tellworks.pagepanel.TellWorksLogin;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReceivingTest extends TellworksBase{

	TellWorksLogin twLogin;
	Receiving receiving;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ReceivingReport.html", true);			
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
		receiving = new Receiving();
		twLogin.login();
	}

	@Test
	public void receivingASNManagementTest() throws InterruptedException {
		extentTest = extent.startTest("receivingASNManagementTest");
		Assert.assertTrue(receiving.ASNManagement());
	}

	@Test
	public void receivingASNApprovalsTest() throws InterruptedException {
		extentTest = extent.startTest("receivingASNApprovalsTest");
		Assert.assertTrue(receiving.ASNManagement());
	}
	
	@Test
	public void receivingManagementTest() throws InterruptedException {
		extentTest = extent.startTest("receivingManagementTest");
		Assert.assertTrue(receiving.ASNManagement());
	}
	
	@Test
	public void receivingReversalsTest() throws InterruptedException {
		extentTest = extent.startTest("receivingReversalsTest");
		Assert.assertTrue(receiving.ASNManagement());
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = CommonMethods.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
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
