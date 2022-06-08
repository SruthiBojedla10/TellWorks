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
import com.miles.tellworks.pagepanel.Deployments;
import com.miles.tellworks.pagepanel.TellWorksLogin;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DeploymentsTest extends TellworksBase {

	TellWorksLogin twLogin;
	Deployments deployments;
	
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/DeploymentsReport.html", true);			
	}
		
	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}
	
	@BeforeClass 
	public void launchBrowser() { 
		  driverInitialization(); 
		  twLogin = new TellWorksLogin(); 
		  deployments = new Deployments(); 
		  twLogin.login();
	}
	 
	@Test
	public void capxTest() throws InterruptedException {
		extentTest = extent.startTest("capxTest");
		Assert.assertTrue(deployments.deploymentCAPXInventory());
	}
	 
	@Test
	public void psmTest() throws InterruptedException {
		extentTest = extent.startTest("psmTest");
		Assert.assertTrue(deployments.deploymentProjectSiteManagement());
	}
	
	@Test
	public void bomTest() throws InterruptedException {
		extentTest = extent.startTest("bomTest");
		Assert.assertTrue(deployments.deploymentBOMMaintenance());
	}

//	@Test
//	public void bomManagementTest() throws InterruptedException {
//		extentTest = extent.startTest("bomManagementTest");
//		Assert.assertTrue(deployments.deploymentBOMManagement());
//	}
	
	@Test
	public void siteTest() throws InterruptedException {
		extentTest = extent.startTest("siteTest");
		Assert.assertTrue(deployments.deploymentSiteEquipment());
	}
	
	@Test
	public void warehouseTest() throws InterruptedException {
		extentTest = extent.startTest("warehouseTest");
		Assert.assertTrue(deployments.deploymentWarehouse());
	}
	
	@Test
	public void bomSSTest() throws InterruptedException {
		extentTest = extent.startTest("bomSSTest");
		Assert.assertTrue(deployments.deploymentBOMShortageSummary());
	}
	
	@Test
	public void oVSdTest() throws InterruptedException {
		extentTest = extent.startTest("oVSdTest");
		Assert.assertTrue(deployments.deploymentOrderedvsDeployed());
	}
	
	@Test
	public void dOPDTest() throws InterruptedException {
		extentTest = extent.startTest("dOPDTest");
		Assert.assertTrue(deployments.deploymentOrderProcessingDetail());
	}
	
	@Test
	public void dSRDSTest() throws InterruptedException {
		extentTest = extent.startTest("dSRDSTest");
		Assert.assertTrue(deployments.deploymentSiteReceivingDS());
	}
	
	@Test
	public void deploymentsEmailNotificationSetupTest() throws InterruptedException {
		extentTest = extent.startTest("deploymentsEmailNotificationSetupTest");
		Assert.assertTrue(deployments.deploymentEmailSetup());
	}
	
	@Test
	public void deploymentsDKRRListTest() throws InterruptedException {
		extentTest = extent.startTest("deploymentsDKRRListTest");
		Assert.assertTrue(deployments.deploymentDKRR());
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
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
