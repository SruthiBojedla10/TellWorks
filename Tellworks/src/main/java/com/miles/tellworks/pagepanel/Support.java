package com.miles.tellworks.pagepanel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import com.miles.tellworks.excelutil.Xls_Reader;
import com.miles.tellworks.mainmenu.TellworksBase;
import com.miles.tellworks.pages.HomePage;
import com.miles.tellworks.pages.Support_ASNManagement;
import com.miles.tellworks.pages.Support_ChartTransfer;
import com.miles.tellworks.pages.Support_CompleteReversalGrid;
import com.miles.tellworks.pages.Support_CompromisedInventoryReconciliation;
import com.miles.tellworks.pages.Support_ConfirmedKitList;
import com.miles.tellworks.pages.Support_ErrorsandAlerts;
import com.miles.tellworks.pages.Support_InventoryAdjustments;
import com.miles.tellworks.pages.Support_InventoryManagement;
import com.miles.tellworks.pages.Support_InventoryMoves;
import com.miles.tellworks.pages.Support_InventoryValidation;
import com.miles.tellworks.pages.Support_LoadBuilderMaintenance;
import com.miles.tellworks.pages.Support_MinMax;
import com.miles.tellworks.pages.Support_OutboundMonitor;
import com.miles.tellworks.pages.Support_PODataSync;
import com.miles.tellworks.pages.Support_PO_SA_Reversals;
import com.miles.tellworks.pages.Support_PickDefectiveInventory;
import com.miles.tellworks.pages.Support_ReceivingManagement;

public class Support extends TellworksBase {

	HomePage homePage;
	CommonMethods commonMethods;
	Support_InventoryManagement supportInventoryManagement;
	Support_CompromisedInventoryReconciliation supportCompromisedInventoryReconciliation;
	Support_PickDefectiveInventory supportPickDefectiveInventory;
	Support_ChartTransfer support_ChartTransfertoRepair;
	Support_MinMax supportMinMax;
	Support_ReceivingManagement supportReceivingManagement;
	Support_ASNManagement supportASNManagement;
	Support_PO_SA_Reversals supportPOSAReversals;
	Support_PODataSync supportPODataSync;
	Support_CompleteReversalGrid supportCompleteReversalGrid;
	Support_ConfirmedKitList supportConfirmedKitList;
	Support_LoadBuilderMaintenance supportLoadBuilderMaintenance;
	Support_OutboundMonitor SupportOutboundMonitor;
	Support_InventoryValidation supportInventoryValidation;
	Support_ErrorsandAlerts supportErrorsandAlerts;
	Support_InventoryMoves supportInventoryMoves;
	Support_InventoryAdjustments supportInventoryAdjustments;
	
	Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "\\TestData\\Tellworks_Data.xlsx");
	
	public boolean SupportInventoryManagement() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		supportInventoryManagement = new Support_InventoryManagement();
		String filter_Search = reader.getCellData("Support_Data", "Market_Filter", 2); 
		homePage.support_Dropdown.click();
		//commonMethods.jsClick(driver.findElement(By.linkText("Inventory Management")));
		Thread.sleep(3000);
		commonMethods.clicklink("Inventory Management");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$GridFilter$ddlMarketList']")));
		select.selectByVisibleText(filter_Search);
		supportInventoryManagement.supportIM_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsOHS = driver.findElements(By.xpath("//table[@id = 'MainContent_gvInventory']/tbody/tr")).size();
		for(int i=1;i<=noofRowsOHS-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gvInventory']/tbody/tr["+(i+1)+"]/td[9]")).getText();
			if(!verifyMarket.equals(filter_Search)) {
				return false;
			}
		}
		Thread.sleep(1000);
		supportInventoryManagement.supportIM_Export_Button.click();
		if(!supportInventoryManagement.supportIM_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(1000);
		supportInventoryManagement.supportIM_Reset_Button.click();
		if(!supportInventoryManagement.supportIM_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean SupportCompromisedInventoryReconciliation() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		supportCompromisedInventoryReconciliation = new Support_CompromisedInventoryReconciliation();
		String filter_Search = reader.getCellData("Support_Data", "Transaction_Filter", 2); 
		homePage.support_Dropdown.click();
		commonMethods.clicklink("Compromised Inventory Reconciliation");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$ddlTransactionType']")));
		select.selectByVisibleText(filter_Search);
		supportCompromisedInventoryReconciliation.supportCIR_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsCIR = driver.findElements(By.xpath("//table[@id = 'MainContent_gvCompromisedInventory']/tbody/tr")).size();
		for(int i=1;i<=noofRowsCIR-1;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gvCompromisedInventory']/tbody/tr["+(i+1)+"]/td[3]")).getText();
			if(!verifyMarket.equals(filter_Search)) {
				return false;
			}
		}
		Thread.sleep(1000);
		supportCompromisedInventoryReconciliation.supportCIR_Export_Button.click();
		if(!supportCompromisedInventoryReconciliation.supportCIR_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(1000);
		supportCompromisedInventoryReconciliation.supportCIR_Reset_Button.click();
		if(!supportCompromisedInventoryReconciliation.supportCIR_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}

	public boolean SupportPickDefectiveInventory() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		supportPickDefectiveInventory = new Support_PickDefectiveInventory();
		String filter_Search = reader.getCellData("Support_Data", "Market_Filter", 2); 
		homePage.support_Dropdown.click();
		commonMethods.clicklink("Pick Defective Inventory");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$GridHeader$ddlMarketList']")));
		select.selectByVisibleText(filter_Search);
		supportPickDefectiveInventory.supportPDI_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsOHS = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsOHS-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[4]")).getText();
			if(!verifyMarket.equals(filter_Search)) {
				return false;
			}
		}
		Thread.sleep(1000);
		supportPickDefectiveInventory.supportPDI_Export_Button.click();
		if(!supportPickDefectiveInventory.supportPDI_Table.isDisplayed()){
			return false;
		}
//		Thread.sleep(1000);
//		supportPickDefectiveInventory.supportPDI_Reset_Button.click();
//		if(!supportPickDefectiveInventory.supportPDI_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
//			return false;
//		}
		return true;
	}
	
	public boolean SupportChartTransfertoRepair() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		support_ChartTransfertoRepair = new Support_ChartTransfer();
		String filter_Search = reader.getCellData("Support_Data", "Return_Filter", 2); 
		homePage.support_Dropdown.click();
		commonMethods.clicklink("CHAT Transfer to Repair");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$ddlFilterReturnType']")));
		select.selectByVisibleText(filter_Search);
		support_ChartTransfertoRepair.supportCTR_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsCTR = driver.findElements(By.xpath("//table[@id = 'MainContent_gvTransfers']/tbody/tr")).size();
		for(int i=1;i<=noofRowsCTR-1;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gvTransfers']/tbody/tr["+(i+1)+"]/td[12]")).getText();
			if(!verifyMarket.equals(filter_Search)) {
				return false;
			}
		}
		Thread.sleep(3000);
		support_ChartTransfertoRepair.supportCTR_Reset_Button.click();
		if(!support_ChartTransfertoRepair.supportCTR_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean SupportMinMax() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		supportMinMax = new Support_MinMax();
		String MM_DropDown = reader.getCellData("Support_Data", "MinMax_DropDown", 2); 
		homePage.support_Dropdown.click();
		commonMethods.clicklink("Min/Max Update");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$ddlMinMaxConfig']")));
		select.selectByVisibleText(MM_DropDown);
		Thread.sleep(3000);
		if(!supportMinMax.supportMM_Table.isDisplayed()) {
				return false;
		}
		Thread.sleep(4000);
		supportMinMax.supportMM_Export_Button.click();
		if(!supportMinMax.supportMM_Table.isDisplayed()){
			return false;
		}
		return true;
	}
	
	public boolean SupportReceivingManagement() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		supportReceivingManagement = new Support_ReceivingManagement();
		String filter_Search = reader.getCellData("Support_Data", "Market_Filter", 2); 
		homePage.support_Dropdown.click();
		commonMethods.clicklink("Receiving Management");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$GridHeader$ddlMarket']")));
		select.selectByVisibleText(filter_Search);
		supportReceivingManagement.supportRM_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsOHS = driver.findElements(By.xpath("//table[@id = 'MainContent_gv_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsOHS-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gv_gv']/tbody/tr["+(i+1)+"]/td[4]")).getText();
			if(!verifyMarket.equals(filter_Search)) {
				return false;
			}
		}
		Thread.sleep(1000);
		supportReceivingManagement.supportRM_Export_Button.click();
		if(!supportReceivingManagement.supportRM_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(1000);
		supportReceivingManagement.supportRM_Reset_Button.click();
		if(!supportReceivingManagement.supportRM_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean SupportASNManagement() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		supportASNManagement = new Support_ASNManagement();
		String filter_Search = reader.getCellData("Support_Data", "ASN_Status", 2); 
		homePage.support_Dropdown.click();
		commonMethods.clicklink("ASN Management");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$ddlFilterApproval']")));
		select.selectByVisibleText(filter_Search);
		supportASNManagement.supportASNM_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsOHS = driver.findElements(By.xpath("//table[@id = 'MainContent_gvSAASNList']/tbody/tr")).size();
		for(int i=1;i<=noofRowsOHS-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gvSAASNList']/tbody/tr["+(i+1)+"]/td[5]")).getText();
			if(!verifyMarket.equals(filter_Search)) {
				return false;
			}
		}
		Thread.sleep(1000);
		supportASNManagement.supportASNM_Export_Button.click();
		if(!supportASNManagement.supportASNM_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(1000);
		supportASNManagement.supportASNM_Reset_Button.click();
		if(!supportASNManagement.supportASNM_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean SupportPOSAReversals() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		supportPOSAReversals = new Support_PO_SA_Reversals();
		String filter_Search = reader.getCellData("Support_Data", "PSR_Status", 2); 
		homePage.support_Dropdown.click();
		commonMethods.clicklink("PO / SA Reversals");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$ddlPOStatus']")));
		select.selectByVisibleText(filter_Search);
		supportPOSAReversals.supportPSR_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsOHS = driver.findElements(By.xpath("//table[@id = 'MainContent_gvPOReversalsList']/tbody/tr")).size();
		for(int i=1;i<=noofRowsOHS-1;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gvPOReversalsList']/tbody/tr["+(i+1)+"]/td[13]")).getText();
			if(!verifyMarket.equals(filter_Search)) {
				return false;
			}
		}
		Thread.sleep(1000);
		supportPOSAReversals.supportPSR_Export_Button.click();
		if(!supportPOSAReversals.supportPSR_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(1000);
		supportPOSAReversals.supportPSR_Reset_Button.click();
		if(!supportPOSAReversals.supportPSR_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean SupportPODataSync() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		supportPODataSync = new Support_PODataSync();
		String filter_Search = reader.getCellData("Support_Data", "PONumber_Search", 2); 
		homePage.support_Dropdown.click();
		commonMethods.clicklink("PO Data Sync");
		supportPODataSync.supportPDS_Search_TextBox.sendKeys(filter_Search);
		supportPODataSync.supportPDS_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsOHS = driver.findElements(By.xpath("//table[@id = 'MainContent_gvErrors']/tbody/tr")).size();
		for(int i=1;i<=noofRowsOHS-1;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gvErrors']/tbody/tr["+(i+1)+"]/td[1]")).getText();
			if(!verifyMarket.equals(filter_Search)) {
				return false;
			}
		}
		Thread.sleep(1000);
		supportPODataSync.supportPDS_Reset_Button.click();
		if(!supportPODataSync.supportPDS_Table.isDisplayed()) {
			return false;
		}
		return true;
	}
	
	public boolean SupportCompleteReversalGrid() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		supportCompleteReversalGrid = new Support_CompleteReversalGrid();
		String CRG_Search = reader.getCellData("Support_Data", "CRG_Search", 2); 
		homePage.support_Dropdown.click();
		commonMethods.clicklink("Complete Reversal Grid");
		supportCompleteReversalGrid.supportCRG_Search_TextBox.sendKeys(CRG_Search);
		Thread.sleep(1000);
		supportCompleteReversalGrid.supportCRG_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsOHS = driver.findElements(By.xpath("//table[@id = 'MainContent_gvCompleteReversalGrid_gvCompleteReversalGrid']/tbody/tr")).size();
		for(int i=1;i<=noofRowsOHS-1;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gvCompleteReversalGrid_gvCompleteReversalGrid']/tbody/tr["+(i+1)+"]/td[3]")).getText();
			if(!verifyMarket.equals(CRG_Search)) {
				return false;
			}
		}
		Thread.sleep(1000);
		supportCompleteReversalGrid.supportCRG_Export_Button.click();
		if(!supportCompleteReversalGrid.supportCRG_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(1000);
		supportCompleteReversalGrid.supportCRG_Reset_Button.click();
		if(!supportCompleteReversalGrid.supportCRG_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean SupportConfirmedKitList() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		supportConfirmedKitList = new Support_ConfirmedKitList();
		String filter_Search = reader.getCellData("Support_Data", "KitStatus", 2); 
		homePage.support_Dropdown.click();
		commonMethods.clicklink("Confirmed Site Kits");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$ddlKitStatusFilter']")));
		select.selectByVisibleText(filter_Search);
		supportConfirmedKitList.supportCKL_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsCTR = driver.findElements(By.xpath("//table[@id = 'MainContent_gvKitList']/tbody/tr")).size();
		for(int i=1;i<=noofRowsCTR-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gvKitList']/tbody/tr["+(i+1)+"]/td[4]")).getText();
			if(!verifyMarket.equals(filter_Search)) {
				return false;
			}
		}
		Thread.sleep(3000);
		supportConfirmedKitList.supportCKL_Reset_Button.click();
		if(!supportConfirmedKitList.supportCKL_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean SupportLoadBuilderMaintenance() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		supportLoadBuilderMaintenance = new Support_LoadBuilderMaintenance();
		String filter_Search = reader.getCellData("Support_Data", "Origin_Filter", 2); 
		homePage.support_Dropdown.click();
		Thread.sleep(3000);
		//commonMethods.jsClick(driver.findElement(By.linkText("Load Builder Maintenance")));
		commonMethods.clicklink("Load Builder Maintenance");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$ddlFilterOriginWarehouse']")));
		select.selectByVisibleText(filter_Search);
		supportLoadBuilderMaintenance.supportLBM_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsCTR = driver.findElements(By.xpath("//table[@id = 'MainContent_gvInventory']/tbody/tr")).size();
		for(int i=1;i<=noofRowsCTR-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gvInventory']/tbody/tr["+(i+1)+"]/td[3]")).getText();
			if(!verifyMarket.equals(filter_Search)) {
				return false;
			}
		}
		Thread.sleep(3000);
		supportLoadBuilderMaintenance.supportLBM_Reset_Button.click();
		if(!supportLoadBuilderMaintenance.supportLBM_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean SupportOutboundMonitor() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		SupportOutboundMonitor = new Support_OutboundMonitor();
		String filter_Search = reader.getCellData("Support_Data", "Market_Filter", 2); 
		homePage.support_Dropdown.click();
		commonMethods.clicklink("Outbound Monitor");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$PickFilter$ddlMarketList']")));
		select.selectByVisibleText(filter_Search);
		SupportOutboundMonitor.supportOM_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsOHS = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsOHS-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[7]")).getText();
			if(!verifyMarket.equals(filter_Search)) {
				return false;
			}
		}
		Thread.sleep(1000);
		SupportOutboundMonitor.supportOM_Export_Button.click();
		if(!SupportOutboundMonitor.supportOM_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(1000);
		SupportOutboundMonitor.supportOM_Reset_Button.click();
		if(!SupportOutboundMonitor.supportOM_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean SupportInventoryValidation() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		supportInventoryValidation = new Support_InventoryValidation();
		homePage.support_Dropdown.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.body.style.zoom = '0.9'");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Inventory Validation vs. In & Out")).click();
		if(!supportInventoryValidation.supportIV_Table.isDisplayed()) {
				return false;
		}
		Thread.sleep(1000);
		supportInventoryValidation.supportIV_ExportBaseline_Button.click();
		if(!supportInventoryValidation.supportIV_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(1000);
		supportInventoryValidation.supportIV_ExportValidation_Button.click();
		if(!supportInventoryValidation.supportIV_Table.isDisplayed()) {
			return false;
		}
		return true;
	}
	
	public boolean SupportErrorsandAlerts() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		supportErrorsandAlerts = new Support_ErrorsandAlerts();
		String filter_Search = reader.getCellData("Support_Data", "Error_Filter", 2); 
		homePage.support_Dropdown.click();
		commonMethods.jsClick(driver.findElement(By.linkText("Errors and Alerts")));
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$GridHeader$ddlErrorType']")));
		select.selectByVisibleText(filter_Search);
		Thread.sleep(3000);
		int noofRowsOHS = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsOHS-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[1]")).getText();
			if(!verifyMarket.equals(filter_Search)) {
				return false;
			}
		}
		Thread.sleep(1000);
		supportErrorsandAlerts.supportEA_Export_Button.click();
		if(!supportErrorsandAlerts.supportEA_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(1000);
		supportErrorsandAlerts.supportEA_Reset_Button.click();
		if(!supportErrorsandAlerts.supportEA_Table.isDisplayed()) {
			return false;
		}
		return true;
	}
	
	public boolean SupportInventoryMoves() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		supportInventoryMoves = new Support_InventoryMoves();
		String filter_Search = reader.getCellData("Inventory_Moves", "Warehouse_Dropdown", 2); 
		homePage.support_Dropdown.click();
		commonMethods.jsClick(driver.findElement(By.linkText("Inventory Moves")));
		Thread.sleep(3000);
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ddlWarehouses']")));
		select.selectByVisibleText(filter_Search);
		Thread.sleep(3000);
		supportInventoryMoves.supportIM_SAP.sendKeys(reader.getCellData("Inventory_Moves", "SAP_Value", 2));
		Thread.sleep(3000);
		Select market = new Select(driver.findElement(By.xpath("//select[@name = 'Markets']")));
		market.selectByVisibleText(reader.getCellData("Inventory_Moves", "Market_Value", 2));
		Thread.sleep(3000);
		Select project = new Select(driver.findElement(By.xpath("//select[@name = 'Projects']")));
		project.selectByVisibleText(reader.getCellData("Inventory_Moves", "Project_value", 2));
		Thread.sleep(3000);
		supportInventoryMoves.supportIM_StorageLocation.sendKeys(reader.getCellData("Inventory_Moves", "StorageLocation", 2));
		Thread.sleep(3000);
		Select status = new Select(driver.findElement(By.xpath("//select[@name = 'Status']")));
		status.selectByVisibleText(reader.getCellData("Inventory_Moves", "Status_Value", 2));
		Thread.sleep(3000);
		Select condition = new Select(driver.findElement(By.xpath("//select[@name = 'Conditions']")));
		condition.selectByVisibleText(reader.getCellData("Inventory_Moves", "Condition_Value", 2));
		supportInventoryMoves.supportIM_firstValidatebutton.click();
		Thread.sleep(2000);
		supportInventoryMoves.supportIM_Move_Quantity.sendKeys(reader.getCellData("Inventory_Moves", "Move_Quantity", 2));
		Select destMarket = new Select(driver.findElement(By.xpath("//select[@name = 'ko_unique_5']")));
		destMarket.selectByVisibleText(reader.getCellData("Inventory_Moves", "Destination_Market", 2));
		Thread.sleep(3000);
		Select destProject = new Select(driver.findElement(By.xpath("//select[@name = 'ko_unique_6']")));
		destProject.selectByVisibleText(reader.getCellData("Inventory_Moves", "Destination_Project", 2));
		Thread.sleep(1000);
		supportInventoryMoves.supportIM_destination_StorageLocation.sendKeys(reader.getCellData("Inventory_Moves", "Destination_StorageLocation", 2));
		Thread.sleep(3000);
		Select reasonCode = new Select(driver.findElement(By.xpath("//select[@name = 'ReasonCodes']")));
		reasonCode.selectByVisibleText(reader.getCellData("Inventory_Moves", "Reason_Codes", 2));
		supportInventoryMoves.supportIM_Confirm_Button.click();
		Thread.sleep(2000);
		commonMethods.jsClick(driver.findElement(By.linkText("Post")));
		Alert alert = driver.switchTo().alert();
		String alertMessage= driver.switchTo().alert().getText();
		alert.dismiss();
		if(!alertMessage.equals("Moves and Transfers have been successfully posted.")) {
			return false;
		}
		return true;
	}
	
	public boolean SupportInventoryAdjustments() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		supportInventoryAdjustments = new Support_InventoryAdjustments();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		Date date = new Date();
		String filter_Search = reader.getCellData("Inventory_Adjustments", "Warehouse_Dropdown", 2); 
		homePage.support_Dropdown.click();
		commonMethods.jsClick(driver.findElement(By.linkText("Inventory Adjustments")));
		Thread.sleep(3000);
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ddlWarehouses']")));
		select.selectByVisibleText(filter_Search);
		Thread.sleep(3000);
		supportInventoryAdjustments.supportIA_SAP.sendKeys(reader.getCellData("Inventory_Adjustments", "SAP_Value", 2));
		Thread.sleep(3000);
		Select market = new Select(driver.findElement(By.xpath("//select[@name = 'Markets']")));
		market.selectByVisibleText(reader.getCellData("Inventory_Adjustments", "Market_Value", 2));
		Thread.sleep(3000);
		Select project = new Select(driver.findElement(By.xpath("//select[@name = 'Projects']")));
		project.selectByVisibleText(reader.getCellData("Inventory_Adjustments", "Project_value", 2));
		Thread.sleep(3000);
		Select status = new Select(driver.findElement(By.xpath("//select[@name = 'Status']")));
		status.selectByVisibleText(reader.getCellData("Inventory_Adjustments", "Status_Value", 2));
		Thread.sleep(3000);
		Select condition = new Select(driver.findElement(By.xpath("//select[@name = 'Conditions']")));
		condition.selectByVisibleText(reader.getCellData("Inventory_Adjustments", "Condition_Value", 2));
		supportInventoryAdjustments.supportIA_StorageLocation.sendKeys(reader.getCellData("Inventory_Adjustments", "StorageLocation", 2));
		supportInventoryAdjustments.supportIA_AdjustQuantity.sendKeys(reader.getCellData("Inventory_Adjustments", "Adjust_Quantity", 2));
		Select reasonCode = new Select(driver.findElement(By.xpath("//select[@name = 'ReasonCodes']")));
		reasonCode.selectByVisibleText(reader.getCellData("Inventory_Adjustments", "Reason_Codes", 2));
		supportInventoryAdjustments.supportIA_Approver.sendKeys(reader.getCellData("Inventory_Adjustments", "Approver", 2));
		supportInventoryAdjustments.supportIA_CountDate.sendKeys(dateFormat.format(date));
		supportInventoryAdjustments.supportIA_Validatebutton.click();
		supportInventoryAdjustments.supportIA_Confirm_Button.click();
		Thread.sleep(2000);
		commonMethods.jsClick(driver.findElement(By.linkText("Post")));
		Alert alert = driver.switchTo().alert();
		String alertMessage= driver.switchTo().alert().getText();
		alert.dismiss();
		if(!alertMessage.equals("Adjustments have been successfully posted.")) {
			return false;
		}
		return true;	
	}
}
