package com.miles.tellworks.pagepanel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.miles.tellworks.excelutil.Xls_Reader;
import com.miles.tellworks.mainmenu.TellworksBase;
import com.miles.tellworks.pages.Deployments_BOMMaintenance;
import com.miles.tellworks.pages.Deployments_BOMManagement;
import com.miles.tellworks.pages.Deployments_BOMSS;
import com.miles.tellworks.pages.Deployments_CAPXInventory;
import com.miles.tellworks.pages.Deployments_DeactivatedKRR;
import com.miles.tellworks.pages.Deployments_EmailSetup;
import com.miles.tellworks.pages.Deployments_OrderPD;
import com.miles.tellworks.pages.Deployments_OrderedvsDeployed;
import com.miles.tellworks.pages.Deployments_ProjectSiteManagement;
import com.miles.tellworks.pages.Deployments_SiteEquipment;
import com.miles.tellworks.pages.Deployments_SiteRD;
import com.miles.tellworks.pages.Deployments_Warehouse;
import com.miles.tellworks.pages.HomePage;

public class Deployments extends TellworksBase {

	HomePage homePage;
	CommonMethods commonMethods;
	Deployments_CAPXInventory deploymentsCAPX;
	Deployments_ProjectSiteManagement deploymentsPSM;
	Deployments_BOMMaintenance deploymentBOM;
	Deployments_BOMManagement deploymentBOMM;
	Deployments_SiteEquipment deploymentSEDH;
	Deployments_Warehouse deploymentWareHouse;
	Deployments_BOMSS deploymentBOMSS;
	Deployments_OrderedvsDeployed deploymentsOvsD;
	Deployments_OrderPD deploymentsOPD;
	Deployments_SiteRD deploymentsSRDS;
	Deployments_EmailSetup deploymentsEmailNS;
	Deployments_DeactivatedKRR deploymentsDKRR;
	
	Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "\\TestData\\Tellworks_Data.xlsx");
		
	public boolean deploymentCAPXInventory() throws InterruptedException 
	{	
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		deploymentsCAPX = new Deployments_CAPXInventory();
		String Market_Search = reader.getCellData("Deployments_Data", "Market_Search", 2);
		homePage.deployements_Dropdown.click();
		commonMethods.clicklink("CAPX Inventory");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$UserFilter$ddlMarketList']")));
		select.selectByVisibleText(Market_Search);
		deploymentsCAPX.capx_Go_Button.click();
		Thread.sleep(8000);
		int noofRowsCI = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsCI-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[5]")).getText();
			if(!verifyMarket.equals(Market_Search)) {
				return false;
			}
		}
		Thread.sleep(2000);
		deploymentsCAPX.capx_Export_Button.click();
		if(!deploymentsCAPX.capx_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(2000);
		deploymentsCAPX.capx_Reset_Button.click();
		if(!deploymentsCAPX.capx_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean deploymentProjectSiteManagement() throws InterruptedException 
	{	
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		deploymentsPSM = new Deployments_ProjectSiteManagement();
		String WareHouse_Search = reader.getCellData("Deployments_Data", "Warehouse_Search", 2);
		homePage.deployements_Dropdown.click();
		commonMethods.clicklink("Project-Site Management");
		Thread.sleep(2000);
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$GridHeader$ddlWarehouse']")));
		select.selectByVisibleText(WareHouse_Search);
		Thread.sleep(2000);
		deploymentsPSM.psm_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsPSM = driver.findElements(By.xpath("//table[@id = 'MainContent_gv_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsPSM-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gv_gv']/tbody/tr["+(i+1)+"]/td[12]")).getText();
			if(!verifyMarket.equals(WareHouse_Search)) {
				return false;
			}
		}
		deploymentsPSM.psm_Export_Button.click();
		if(!deploymentsPSM.psm_Table.isDisplayed()){
			return false;
		}
//		Thread.sleep(2000);
//		deploymentsPSM.psm_Reset_Button.click();
//		if(!deploymentsPSM.psm_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
//			return false;
//		}
		return true;
	}
	
	public boolean deploymentBOMMaintenance() throws InterruptedException 
	{	
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		deploymentBOM = new Deployments_BOMMaintenance();
		String Market_Search = reader.getCellData("Deployments_Data", "Market_Search", 2);
		homePage.deployements_Dropdown.click();
		commonMethods.clicklink("BOM Maintenance");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$BOMHeader$ddlMarket']")));
		select.selectByVisibleText(Market_Search);
		Thread.sleep(8000);
		deploymentBOM.bom_Go_Button.click();
		int noofRowsCI = driver.findElements(By.xpath("//table[@id = 'MainContent_gvBOMList']/tbody/tr")).size();
		for(int i=1;i<=noofRowsCI-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gvBOMList']/tbody/tr["+(i+1)+"]/td[4]")).getText();
			if(!verifyMarket.equals(Market_Search)) {
				return false;
			}
		}
		Thread.sleep(2000);
		deploymentBOM.bom_Reset_Button.click();
		if(!deploymentBOM.bom_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean deploymentBOMManagement() throws InterruptedException 
	{	
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		deploymentBOMM = new Deployments_BOMManagement();
		String Market_Search = reader.getCellData("Deployments_Data", "Market_Search", 2);
		homePage.deployements_Dropdown.click();
		commonMethods.clicklink("Open BOM Management");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$GridHeader$ddlMarketList']")));
		select.selectByVisibleText(Market_Search);
		deploymentBOMM.bomM_Go_Button.click();
		Thread.sleep(8000);
		int noofRowsBM = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsBM-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[6]")).getText();
			if(!verifyMarket.equals(Market_Search)) {
				return false;
			}
		}
		Thread.sleep(2000);
		deploymentBOMM.bomM_Export_Button.click();
		if(!deploymentBOMM.bomM_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(2000);
		deploymentBOMM.bomM_Reset_Button.click();
		if(!deploymentBOMM.bomM_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean deploymentSiteEquipment() throws InterruptedException 
	{	
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		deploymentSEDH = new Deployments_SiteEquipment();
		String Market_Search = reader.getCellData("Deployments_Data", "Market_Search", 2);
		homePage.deployements_Dropdown.click();
		commonMethods.clicklink("Site Equipment Deployment History");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$PickFilter$ddlMarketList']")));
		select.selectByVisibleText(Market_Search);
		deploymentSEDH.sedh_Go_Button.click();
		Thread.sleep(8000);
		int noofRowsBM = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsBM-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[9]")).getText();
			if(!verifyMarket.equals(Market_Search)) {
				return false;
			}
		}
		Thread.sleep(2000);
		deploymentSEDH.sedh_Export_Button.click();
		if(!deploymentSEDH.sedh_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(2000);
		deploymentSEDH.sedh_Reset_Button.click();
		if(!deploymentSEDH.sedh_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean deploymentWarehouse() throws InterruptedException 
	{	
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		deploymentWareHouse = new Deployments_Warehouse();
		String Warehouse_Search = reader.getCellData("Deployments_Data", "Warehouse_Search", 2);
		homePage.deployements_Dropdown.click();
		commonMethods.clicklink("Warehouse Schedule");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$GridHeader$ddlWarehouseList']")));
		select.selectByVisibleText(Warehouse_Search);
		Thread.sleep(3000);
		int noofRowsBM = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsBM-1;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[1]")).getText();
			if(!verifyMarket.equals(Warehouse_Search)) {
				return false;
			}
		}
		Thread.sleep(2000);
		deploymentWareHouse.wareHouse_Export_Button.click();
		if(!deploymentWareHouse.wareHouse_Table.isDisplayed()){
			return false;
		}
//		Thread.sleep(2000);
//		deploymentWareHouse.wareHouse_Reset_Button.click();
//		if(!deploymentWareHouse.wareHouse_Reset_Message.getText().equals("No records found")) {
//			return false;
//		}
		return true;
	}
	
	public boolean deploymentBOMShortageSummary() throws InterruptedException 
	{	
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		deploymentBOMSS = new Deployments_BOMSS();
		String Market_Search = reader.getCellData("Deployments_Data", "Market_Search", 2);
		homePage.deployements_Dropdown.click();
		commonMethods.clicklink("BOM Shortage Summary");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$GridFilter$ddlMarketList']")));
		select.selectByVisibleText(Market_Search);
		deploymentBOMSS.bomSS_Go_Button.click();
		Thread.sleep(8000);
		int noofRowsCI = driver.findElements(By.xpath("//table[@id = 'MainContent_gvBOMShortages']/tbody/tr")).size();
		for(int i=1;i<=noofRowsCI-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gvBOMShortages']/tbody/tr["+(i+1)+"]/td[1]")).getText();
			if(!verifyMarket.equals(Market_Search)) {
				return false;
			}
		}
		Thread.sleep(2000);
		deploymentBOMSS.bomSS_Export_Button.click();
		if(!deploymentBOMSS.bomSS_Table.isDisplayed()){
			return false;
		}
//		Thread.sleep(2000);
//		deploymentBOMSS.bomSS_Reset_Button.click();
//		if(!deploymentBOMSS.bomSS_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
//			return false;
//		}
		return true;
	}
	
	public boolean deploymentOrderedvsDeployed() throws InterruptedException 
	{	
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		deploymentsOvsD = new Deployments_OrderedvsDeployed();
		String CartClass_Search = reader.getCellData("Deployments_Data", "Cart_Class", 2);
		homePage.deployements_Dropdown.click();
		commonMethods.clicklink("Ordered vs. Deployed");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$GridHeader$ddlCartClass']")));
		select.selectByVisibleText(CartClass_Search);
		deploymentsOvsD.dOvsD_Go_Button.click();
		Thread.sleep(4000);
		int noofRowsCI = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsCI-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[7]")).getText();
			if(!verifyMarket.equals(CartClass_Search)) {
				return false;
			}
		}
		Thread.sleep(2000);
		deploymentsOvsD.dOvsD_Export_Button.click();
		if(!deploymentsOvsD.dOvsD_Table.isDisplayed()){
			return false;
		}
//		Thread.sleep(2000);
//		deploymentsOvsD.dOvsD_Reset_Button.click();
//		if(!deploymentsOvsD.dOvsD_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
//			return false;
//		}
		return true;
	}
	
	public boolean deploymentOrderProcessingDetail() throws InterruptedException 
	{	
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		deploymentsOPD = new Deployments_OrderPD();
		String CartClass_Search = reader.getCellData("Deployments_Data", "Cart_Class", 2);
		homePage.deployements_Dropdown.click();
		commonMethods.clicklink("Order Processing Detail");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$GridHeader$ddlCartClass']")));
		select.selectByVisibleText(CartClass_Search);
		deploymentsOPD.dOPD_Go_Button.click();
		Thread.sleep(4000);
		int noofRowsCI = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsCI-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[4]")).getText();
			if(!verifyMarket.equals(CartClass_Search)) {
				return false;
			}
		}
		Thread.sleep(2000);
		deploymentsOPD.dOPD_Export_Button.click();
		if(!deploymentsOPD.dOPD_Table.isDisplayed()){
			return false;
		}
//		Thread.sleep(2000);
//		deploymentsOPD.dOPD_Reset_Button.click();
//		if(!deploymentsOPD.dOPD_Reset_Message.getText().equals("No records found")) {
//			return false;
//		}
		return true;
	}
	
	public boolean deploymentSiteReceivingDS() throws InterruptedException 
	{	
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		deploymentsSRDS = new Deployments_SiteRD();
		String Market_Search = reader.getCellData("Deployments_Data", "Market_Search", 2);
		homePage.deployements_Dropdown.click();
		commonMethods.clicklink("Site Receiving & Deployment");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$GridHeader$ddlMarket']")));
		select.selectByVisibleText(Market_Search);
		deploymentsSRDS.dSRDS_Go_Button.click();
		Thread.sleep(4000);
		int noofRowsCI = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsCI-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[1]")).getText();
			if(!verifyMarket.equals(Market_Search)) {
				return false;
			}
		}
		Thread.sleep(2000);
		deploymentsSRDS.dSRDS_Export_Button.click();
		if(!deploymentsSRDS.dSRDS_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(2000);
		deploymentsSRDS.dSRDS_Reset_Button.click();
		if(!deploymentsSRDS.dSRDS_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean deploymentEmailSetup() throws InterruptedException 
	{	
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		deploymentsEmailNS = new Deployments_EmailSetup();
		String Market_Search = reader.getCellData("Deployments_Data", "Email_Search", 2);
		homePage.deployements_Dropdown.click();
		commonMethods.clicklink("Email Notification Setup");
		deploymentsEmailNS.eMail_Search_TextBox.sendKeys(Market_Search);
		deploymentsEmailNS.eMail_Go_Button.click();
		Thread.sleep(2000);
		int noofRowsENS = driver.findElements(By.xpath("//table[@id = 'MainContent_gvEmailNotificationList_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsENS-1;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gvEmailNotificationList_gv']/tbody/tr["+(i+1)+"]/td[1]")).getText();
			if(!verifyMarket.equals(Market_Search)) {
				return false;
			}
		}
		deploymentsEmailNS.eMail_Reset_Button.click();
		if(!deploymentsEmailNS.eMail_Table.isDisplayed()) {
			return false;
		}
		return true;
	}
	
	public boolean deploymentDKRR() throws InterruptedException 
	{	
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		deploymentsDKRR = new Deployments_DeactivatedKRR();
		String BOMStatus_Search = reader.getCellData("Deployments_Data", "BOMStatus", 2);
		homePage.deployements_Dropdown.click();
		commonMethods.jsClick(driver.findElement(By.linkText("Deactivated Kits Returned Received (DKRR)")));
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$ddlFilterBOMHeaderKitStatus']")));
		select.selectByVisibleText(BOMStatus_Search);
		deploymentsDKRR.dkrr_Go_Button.click();
		Thread.sleep(4000);
		int noofRowsCI = driver.findElements(By.xpath("//table[@id = 'MainContent_gvKitList']/tbody/tr")).size();
		for(int i=1;i<=noofRowsCI-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gvKitList']/tbody/tr["+(i+1)+"]/td[4]")).getText();
			if(!verifyMarket.equals(BOMStatus_Search)) {
				return false;
			}
		}
		Thread.sleep(2000);
		deploymentsDKRR.dkrr_Export_Button.click();
		if(!deploymentsDKRR.dkrr_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(2000);
		deploymentsDKRR.dkrr_Reset_Button.click();
		if(!deploymentsDKRR.dkrr_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
}
