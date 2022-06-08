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
import com.miles.tellworks.pagepanel.Admin;
import com.miles.tellworks.pagepanel.CommonMethods;
import com.miles.tellworks.pagepanel.HomePagePanel;
import com.miles.tellworks.pagepanel.TellWorksLogin;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdminTest extends TellworksBase {
	
	TellWorksLogin twlogin;
	HomePagePanel homepage;
	Admin admin;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/AdminReport.html", true);			
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
		admin = new Admin();
		twlogin.login();
	}

	@Test
	public void userAdministratationTest() throws InterruptedException {
		extentTest = extent.startTest("userAdministratationTest");
		Assert.assertEquals(homepage.HomePageTitleVerification(), "Tellworks AIMS -");
		Assert.assertTrue(admin.userAdministration());
	}

	@Test
	public void userAuditTest() throws InterruptedException {
		extentTest = extent.startTest("userAuditTest");
		Assert.assertTrue(admin.userAuditLog()); 
	} 
	
	@Test
	public void controlTableRegionsTest() throws InterruptedException {
		extentTest = extent.startTest("controlTableRegionsTest");
		Assert.assertTrue(admin.controlTables_Regions()); 
	} 
	
	@Test
	public void controlTableAreasTest() throws InterruptedException {
		extentTest = extent.startTest("controlTableAreasTest");
		Assert.assertTrue(admin.controlTables_Areas()); 
	} 
	
	@Test
	public void controlTableMarketTest() throws InterruptedException {
		extentTest = extent.startTest("controlTableMarketTest");
		Assert.assertTrue(admin.controlTables_Market()); 
	} 
	
	@Test
	public void controlTableProjectTest() throws InterruptedException {
		extentTest = extent.startTest("controlTableProjectTest");
		Assert.assertTrue(admin.controlTables_Project()); 
	} 
	
	@Test
	public void regionAreaMarketTest() throws InterruptedException {
		extentTest = extent.startTest("regionAreaMarketTest");
		Assert.assertTrue(admin.regionsAreasMarket()); 
	} 
	
	@Test
	public void marketProjectTest() throws InterruptedException {
		extentTest = extent.startTest("marketProjectTest");
		Assert.assertTrue(admin.marketProject()); 
	} 

	@Test
	public void partMasterTest() throws InterruptedException {
		extentTest = extent.startTest("partMasterTest");
		Assert.assertTrue(admin.partMaster()); 
	} 
	
	@Test
	public void partMaintenanceTest() throws InterruptedException {
		extentTest = extent.startTest("partMaintenanceTest");
		Assert.assertTrue(admin.partMaintenance()); 
	} 
	
	@Test
	public void adminWarehouseTest() throws InterruptedException {
		extentTest = extent.startTest("adminWarehouseTest");
		Assert.assertTrue(admin.adminWarehouse()); 
	} 
	
	@Test
	public void adminWarehouseLocationTest() throws InterruptedException {
		extentTest = extent.startTest("adminWarehouseLocationTest");
		Assert.assertTrue(admin.adminWarehouse_Location()); 
	} 
	
	@Test
	public void adminWarehouseZonesTest() throws InterruptedException {
		extentTest = extent.startTest("adminWarehouseZonesTest");
		Assert.assertTrue(admin.adminWarehouse_Zones()); 
	}
	
	@Test
	public void adminSerialManagementTest() throws InterruptedException {
		extentTest = extent.startTest("adminSerialManagementTest");
		Assert.assertTrue(admin.adminSerialManagement()); 
	} 
	
	@Test
	public void adminReasonCodesTest() throws InterruptedException {
		extentTest = extent.startTest("adminReasonCodesTest");
		Assert.assertTrue(admin.adminReasonCodes()); 
	} 
	
	@Test
	public void adminAdjustmentReasonCodesTest() throws InterruptedException {
		extentTest = extent.startTest("adminAdjustmentReasonCodesTest");
		Assert.assertTrue(admin.adminAdjustmentReasonCodes()); 
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
