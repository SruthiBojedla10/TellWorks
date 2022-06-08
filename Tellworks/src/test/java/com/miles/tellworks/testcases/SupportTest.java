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
import com.miles.tellworks.pagepanel.HomePagePanel;
import com.miles.tellworks.pagepanel.Support;
import com.miles.tellworks.pagepanel.TellWorksLogin;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SupportTest extends TellworksBase {
	
	TellWorksLogin twlogin;
	HomePagePanel homepage;
	Support support;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/SupportReport.html", true);			
	}
		
	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}
	
	@BeforeClass
	public void launchBrowser() {
		driverInitialization();
		twlogin = new TellWorksLogin();
		homepage = new HomePagePanel();
		support = new Support();
		twlogin.login();
	}
	
	@Test(priority=1)
	public void SupportCompromisedInventoryReconciliationTest() throws InterruptedException {
		extentTest = extent.startTest("SupportCompromisedInventoryReconciliationTest");
		Assert.assertTrue(support.SupportCompromisedInventoryReconciliation());
	}
	
	@Test(priority=2)
	public void SupportPickDefectiveInventoryTest() throws InterruptedException {
		extentTest = extent.startTest("SupportPickDefectiveInventoryTest");
		Assert.assertTrue(support.SupportPickDefectiveInventory());
	}
	
	@Test(priority=3)
	public void SupportChartTransfertoRepairTest() throws InterruptedException {
		extentTest = extent.startTest("SupportChartTransfertoRepairTest");
		Assert.assertTrue(support.SupportChartTransfertoRepair());
	}
	
	@Test
	public void SupportMinMaxTest() throws InterruptedException {
		extentTest = extent.startTest("SupportMinMaxTest");
		Assert.assertTrue(support.SupportMinMax());
	}
	
	@Test(priority=4)
	public void SupportReceivingManagementTest() throws InterruptedException {
		extentTest = extent.startTest("SupportReceivingManagementTest");
		Assert.assertTrue(support.SupportReceivingManagement());
	}
	
	@Test(priority=5)
	public void SupportASNManagementTest() throws InterruptedException {
		extentTest = extent.startTest("SupportASNManagementTest");
		Assert.assertTrue(support.SupportASNManagement());
	}
	
	@Test(priority=6)
	public void SupportPOSAReversalsTest() throws InterruptedException {
		extentTest = extent.startTest("SupportPOSAReversalsTest");
		Assert.assertTrue(support.SupportPOSAReversals());
	}
	
	@Test(priority=10)
	public void SupportPODataSyncTest() throws InterruptedException {
		extentTest = extent.startTest("SupportPODataSyncTest");
		Assert.assertTrue(support.SupportPODataSync());
	}
	
	@Test(priority=7)
	public void SupportCompleteReversalGridTest() throws InterruptedException {
		extentTest = extent.startTest("SupportCompleteReversalGridTest");
		Assert.assertTrue(support.SupportCompleteReversalGrid());
	}
	
	@Test(priority=8)
	public void SupportConfirmedKitListTest() throws InterruptedException {
		extentTest = extent.startTest("SupportConfirmedKitListTest");
		Assert.assertTrue(support.SupportConfirmedKitList());
	}
	
	@Test(priority=9)
	public void SupportLoadBuilderMaintenanceTest() throws InterruptedException {
		extentTest = extent.startTest("SupportLoadBuilderMaintenanceTest");
		Assert.assertTrue(support.SupportLoadBuilderMaintenance());
	}
	
	@Test(priority=11)
	public void SupportOutboundMonitorTest() throws InterruptedException {
		extentTest = extent.startTest("SupportOutboundMonitorTest");
		Assert.assertTrue(support.SupportOutboundMonitor());
	}
	
	@Test(priority=0)
	public void SupportErrorsandAlertsTest() throws InterruptedException {
		extentTest = extent.startTest("SupportErrorsandAlertsTest");
		Assert.assertTrue(support.SupportErrorsandAlerts());
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
