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
import com.miles.tellworks.pagepanel.Maintenance;
import com.miles.tellworks.pagepanel.TellWorksLogin;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MaintenanceTest extends TellworksBase{

	TellWorksLogin twLogin;
	Maintenance maintenance;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/MaintenanceReport.html", true);			
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
		maintenance = new Maintenance();
		twLogin.login();
	}

	@Test
	public void PartMaintenanceTest() throws InterruptedException {
		extentTest = extent.startTest("PartMaintenanceTest");
		Assert.assertTrue(maintenance.PartMaintenance());
	}

	@Test
	public void SupplierMaintenanceTest() throws InterruptedException {
		extentTest = extent.startTest("SupplierMaintenanceTest");
		Assert.assertTrue(maintenance.SupplierMaintenance());
	}
	
	@Test
	public void maintenanceWarehouseTest() throws InterruptedException {
		extentTest = extent.startTest("maintenanceWarehouseTest");
		Assert.assertTrue(maintenance.maintenanceWarehouse());
	}

	@Test
	public void maintenanceLocationTest() throws InterruptedException {
		extentTest = extent.startTest("maintenanceLocationTest");
		Assert.assertTrue(maintenance.maintenanceWarehouse_Location());
	}
	
	@Test
	public void maintenanceZoneTest() throws InterruptedException {
		extentTest = extent.startTest("maintenanceZoneTest");
		Assert.assertTrue(maintenance.maintenanceWarehouse_Zones());
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
