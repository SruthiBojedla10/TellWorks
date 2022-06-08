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
import com.miles.tellworks.pagepanel.Inventory;
import com.miles.tellworks.pagepanel.TellWorksLogin;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class InventoryTest extends TellworksBase {

	TellWorksLogin twLogin;
	Inventory inventory;
	CommonMethods commonMethods;
	
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/InventoryReport.html", true);			
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
		  inventory = new Inventory(); 
		  twLogin.login();
	  
	  }
	 
	@Test
	public void shippedTest() throws InterruptedException {
		extentTest = extent.startTest("shippedTest");
		Assert.assertTrue(inventory.shippedInventory());

	}
	
	@Test
	public void onHandSummaryTest() throws InterruptedException {
		extentTest = extent.startTest("onHandSummaryTest");
		Assert.assertTrue(inventory.onHandSummaryInventory());

	}
	
	@Test
	public void stagedTest() throws InterruptedException {
		extentTest = extent.startTest("stagedTest");
		Assert.assertTrue(inventory.stagedInventory());

	}
	
	@Test
	public void stagedInventoryDetailsTest() throws InterruptedException {
		extentTest = extent.startTest("stagedInventoryDetailsTest");
		Assert.assertTrue(inventory.stagedInventoryDetails());

	}
	
	@Test
	public void receivedTest() throws InterruptedException {
		extentTest = extent.startTest("receivedTest");
		Assert.assertTrue(inventory.receivedInventory());

	}
	
	@Test
	public void partMasterTest() throws InterruptedException {
		extentTest = extent.startTest("partMasterTest");
		Assert.assertTrue(inventory.partMasterInventory());

	}
	
	@Test
	public void cycleManagementTest() throws InterruptedException {
		extentTest = extent.startTest("cycleManagementTest");
		Assert.assertTrue(inventory.cycleCountInventory());

	}
	
	@Test
	public void minmaxTest() throws InterruptedException {
		extentTest = extent.startTest("minmaxTest");
		Assert.assertTrue(inventory.inventory_MinMax());

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
