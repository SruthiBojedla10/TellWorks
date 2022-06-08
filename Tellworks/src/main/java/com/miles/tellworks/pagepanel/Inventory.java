package com.miles.tellworks.pagepanel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.miles.tellworks.excelutil.Xls_Reader;
import com.miles.tellworks.mainmenu.TellworksBase;
import com.miles.tellworks.pages.HomePage;
import com.miles.tellworks.pages.Inventory_CycleManagement;
import com.miles.tellworks.pages.Inventory_MinMax;
import com.miles.tellworks.pages.Inventory_OnHandSummary;
import com.miles.tellworks.pages.Inventory_PartMaster;
import com.miles.tellworks.pages.Inventory_Received;
import com.miles.tellworks.pages.Inventory_Shipped;
import com.miles.tellworks.pages.Inventory_StagedInventory;
import com.miles.tellworks.pages.Inventory_StagedInventoryDetails;

public class Inventory extends TellworksBase {

	HomePage homePage;
	CommonMethods commonMethods;
	Inventory_OnHandSummary inventoryOHS;
	Inventory_StagedInventory inventorySI;
	Inventory_StagedInventoryDetails inventorySID;
	Inventory_Shipped inventoryShipped;
	Inventory_Received inventoryReceived;
	Inventory_PartMaster inventoryPartMaster;
	Inventory_CycleManagement inventoryCycleManagement;
	Inventory_MinMax inventoryMM;
	
	Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "\\TestData\\Tellworks_Data.xlsx");
	
	public boolean onHandSummaryInventory() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		inventoryOHS = new Inventory_OnHandSummary();
		String filter_Search = reader.getCellData("Inventory_Data", "Market_Filter", 2); 
		homePage.inventory_Dropdown.click();
		commonMethods.clicklink("On Hand Summary");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$UserFilter$ddlMarketList']")));
		select.selectByVisibleText(filter_Search);
		Thread.sleep(10000);
		inventoryOHS.onHandSummary_Go_Button.click();
		Thread.sleep(1000);
		int noofRowsOHS = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsOHS-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[5]")).getText();
			if(!verifyMarket.equals(filter_Search)) {
				return false;
			}
		}
		Thread.sleep(1000);
		inventoryOHS.onHandSummary_Export_Button.click();
		if(!inventoryOHS.onHandSummary_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(1000);
		inventoryOHS.onHandSummary_Reset_Button.click();
		if(!inventoryOHS.onHandSummary_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean stagedInventory() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		inventorySI = new Inventory_StagedInventory();
		String filter_Search = reader.getCellData("Inventory_Data", "StagedMarket", 2); 
		homePage.inventory_Dropdown.click();
		commonMethods.clicklink("Staged Inventory");
		Select select = new Select(driver.findElement(By.xpath("//select[@id = 'MainContent_GridFilter_ddlMarketList']")));
		select.selectByVisibleText(filter_Search);
		Thread.sleep(6000);
		inventorySI.stagedInventory_Go_Button.click();
		Thread.sleep(1000);
		int noofRowsSI = driver.findElements(By.xpath("//table[@id = 'MainContent_gvInventory']/tbody/tr")).size();
		for(int i=1;i<=noofRowsSI-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gvInventory']/tbody/tr["+(i+1)+"]/td[6]")).getText();
			if(!verifyMarket.equals(filter_Search)) {
				return false;
			}
		}
		inventorySI.stagedInventory_Export_Button.click();
		if(!inventorySI.stagedInventory_Table.isDisplayed()){
			return false;
		}
		inventorySI.stagedInventory_Reset_Button.click();
		if(!inventorySI.stagedInventory_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean stagedInventoryDetails() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		inventorySID = new Inventory_StagedInventoryDetails();
		String filter_Search = reader.getCellData("Inventory_Data", "StagedMarket", 2); 
		homePage.inventory_Dropdown.click();
		commonMethods.clicklink("Staged Inventory Details");
		Select select = new Select(driver.findElement(By.xpath("//select[@id = 'MainContent_GridFilter_ddlMarketList']")));
		select.selectByVisibleText(filter_Search);
		Thread.sleep(3000);
		inventorySID.stagedInventoryDetails_Go_Button.click();
		Thread.sleep(1000);
		int noofRowsSID = driver.findElements(By.xpath("//table[@id = 'MainContent_gvInventory']/tbody/tr")).size();
		for(int i=1;i<=noofRowsSID-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gvInventory']/tbody/tr["+(i+1)+"]/td[6]")).getText();
			if(!verifyMarket.equals(filter_Search)) {
				return false;
			}
		}
		Thread.sleep(3000);
		inventorySID.stagedInventoryDetails_Export_Button.click();
		if(!inventorySID.stagedInventoryDetails_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(3000);
		inventorySID.stagedInventoryDetails_Reset_Button.click();
		if(!inventorySID.stagedInventoryDetails_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean shippedInventory() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		inventoryShipped = new Inventory_Shipped();
		String filter_Search = reader.getCellData("Inventory_Data", "Shipped_Warehouse", 2); 
		homePage.inventory_Dropdown.click();
		commonMethods.clicklink("Shipped");
		Select select = new Select(driver.findElement(By.xpath("//select[@id = 'MainContent_UserFilter_ddlWarehouseList']")));
		select.selectByVisibleText(filter_Search);
		Thread.sleep(5000);
		inventoryShipped.shipped_search_Button.sendKeys("34481");
		Select fields = new Select(driver.findElement(By.xpath("//select[@id = 'MainContent_UserFilter_ddlSearchType']")));
		fields.selectByVisibleText("SAP");
		Thread.sleep(3000);
		inventoryShipped.shipped_Go_Button.click();
		Thread.sleep(1000);
		int noofRowsSI = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsSI-2;i++) {
			String verifyWareHouse = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[8]")).getText();
			if(!verifyWareHouse.equals(filter_Search)) {
				return false;
			}
		}
		Thread.sleep(3000);
		inventoryShipped.shipped_Export_Button.click();
		if(!inventoryShipped.shipped_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(3000);
		inventoryShipped.shipped_Reset_Button.click();
		Thread.sleep(6000);
		if(!inventoryShipped.shipped_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}

	public boolean receivedInventory() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		inventoryReceived = new Inventory_Received();
		String filter_Search = reader.getCellData("Inventory_Data", "Shipped_Warehouse", 2);
		homePage.inventory_Dropdown.click();
		commonMethods.clicklink("Received");
		Select select = new Select(driver.findElement(By.xpath("//select[@id = 'MainContent_UserFilter_ddlWarehouseList']")));
		select.selectByVisibleText(filter_Search);
		Thread.sleep(3000);
		inventoryReceived.received_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsRI = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsRI-2;i++) {
			String verifyWareHouse = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[8]")).getText();
			if(!verifyWareHouse.equals(filter_Search)) {
				return false;
			}
		}
		inventoryReceived.received_Export_Button.click();
		if(!inventoryReceived.received_Table.isDisplayed()){
			return false;
		}
		inventoryReceived.received_Reset_Button.click();
		if(!inventoryReceived.received_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean partMasterInventory() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		inventoryPartMaster = new Inventory_PartMaster();
		String filter_Search = reader.getCellData("Inventory_Data", "PartMaster_Search", 2);
		homePage.inventory_Dropdown.click();
		commonMethods.jsClick(driver.findElement(By.xpath("//a[contains(text(),'Part Master')]")));
		inventoryPartMaster.partMaster_Search_TextBox.sendKeys(filter_Search);
		inventoryPartMaster.partMaster_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsPM = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsPM-1;i++) {
			String verifyMfgPM = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[2]")).getText();
			if(!verifyMfgPM.equals(filter_Search)) {
				return false;
			}
		}
		inventoryPartMaster.partMaster_Export_Button.click();
		if(!inventoryPartMaster.partMaster_Table.isDisplayed()){
			return false;
		}
		inventoryPartMaster.partMaster_Reset_Button.click();
		if(!inventoryPartMaster.partMaster_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean cycleCountInventory() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		inventoryCycleManagement = new Inventory_CycleManagement();
		String filter_Search = reader.getCellData("Inventory_Data", "CCM_Inventory", 2);
		homePage.inventory_Dropdown.click();
		commonMethods.clicklink("Cycle Count Management");
		Select select = new Select(driver.findElement(By.xpath("//select[@id = 'MainContent_ddlFilterWarehouse']")));
		select.selectByVisibleText(filter_Search);
		Thread.sleep(1000);
		inventoryCycleManagement.cycleCountManagement_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsCCM = driver.findElements(By.xpath("//table[@id = 'MainContent_gvList']/tbody/tr")).size();
		for(int i=1;i<=noofRowsCCM-2;i++) {
			String verifyWareHouse = driver.findElement(By.xpath("//table[@id = 'MainContent_gvList']/tbody/tr["+(i+1)+"]/td[2]")).getText();
			if(!verifyWareHouse.equals(filter_Search)) {
				return false;
			}
		}
		Thread.sleep(1000);
		inventoryCycleManagement.cycleCountManagement_Reset_Button.click();
		if(!inventoryCycleManagement.cycleCountManagement_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean inventory_MinMax() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		inventoryMM = new Inventory_MinMax();
		homePage.inventory_Dropdown.click();
		commonMethods.clicklink("Min/Max");
		boolean minMaxTable = inventoryMM.inventory_MinMax__Table.isDisplayed();
		return minMaxTable;
	}
}
