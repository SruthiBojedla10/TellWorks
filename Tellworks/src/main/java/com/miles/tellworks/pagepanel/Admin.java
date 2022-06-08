package com.miles.tellworks.pagepanel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.miles.tellworks.excelutil.Xls_Reader;
import com.miles.tellworks.mainmenu.TellworksBase;
import com.miles.tellworks.pages.HomePage;
import com.miles.tellworks.pages.Admin_AdjustmentCodes;
import com.miles.tellworks.pages.Admin_ControlTables;
import com.miles.tellworks.pages.Admin_Market_Project;
import com.miles.tellworks.pages.Admin_PartMaintenance;
import com.miles.tellworks.pages.Admin_PartMaster;
import com.miles.tellworks.pages.Admin_ReasonCodes;
import com.miles.tellworks.pages.Admin_Regions_Areas_Market;
import com.miles.tellworks.pages.Admin_SerialManagement;
import com.miles.tellworks.pages.Admin_UserAdministration;
import com.miles.tellworks.pages.Admin_UserAuditLog;
import com.miles.tellworks.pages.Admin_Warehouse;

public class Admin extends TellworksBase {

	HomePage homePage;
	CommonMethods commonMethods;
	Admin_UserAdministration userAdmin;
	Admin_UserAuditLog userAuditLog;
	Admin_ControlTables controlTables;
	Admin_Regions_Areas_Market adminRAM;
	Admin_Market_Project adminMP;
	Admin_PartMaster partmaster;
	Admin_PartMaintenance partmaintian;
	Admin_Warehouse adminWarehouse;
	Admin_SerialManagement adminSerialM;
	Admin_ReasonCodes adminReasonCodes;
	Admin_AdjustmentCodes adminAdjustmentCodes;
	   
	Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "\\TestData\\Tellworks_Data.xlsx");
	
	public boolean userAdministration() throws InterruptedException {
		
		homePage = new HomePage();
		commonMethods = new CommonMethods();
		userAdmin = new Admin_UserAdministration();
		String username_Search = reader.getCellData("Search_Data", "UserSearch", 2); 
		homePage.admin_Dropdown.click();
		commonMethods.clicklink("Users");
		userAdmin.users_Search_TextBox.sendKeys(username_Search);
		userAdmin.users_Go_Button.click();
		Thread.sleep(1000);
		int noofRows = driver.findElements(By.xpath("//table[@id = 'MainContent_gvUsers']/tbody/tr")).size();
		for(int i=1;i<=noofRows-2;i++) {
			String verifyUsername = driver.findElement(By.xpath("//table[@id = 'MainContent_gvUsers']/tbody/tr["+(i+1)+"]/td[1]")).getText();
			if(!verifyUsername.equals(username_Search)) {
				return false;
			}
		}
		userAdmin.users_Export_Button.click();
		if(!userAdmin.users_Table.isDisplayed()){
			return false;
		}
		userAdmin.users_Reset_Button.click();
		if(!userAdmin.users_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}

	public boolean userAuditLog() throws InterruptedException {

		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		userAuditLog = new Admin_UserAuditLog();
		String UserAudit_username_Search = reader.getCellData("Search_Data", "UserAudit", 2); 
		homePage.admin_Dropdown.click();
		commonMethods.clicklink("User Audit Log");
		userAuditLog.usersAudit_Search_TextBox.sendKeys(UserAudit_username_Search);
		userAuditLog.usersAudit_Go_Button.click();
		Thread.sleep(1000);
		int noofRows = driver.findElements(By.xpath("//table[@id = 'MainContent_gvUserAuditLogs_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRows-1;i++) {
			String verifyUsername = driver.findElement(By.xpath("//table[@id = 'MainContent_gvUserAuditLogs_gv']/tbody/tr["+(i+1)+"]/td[2]")).getText();
			if(!verifyUsername.equals(UserAudit_username_Search)) {
				return false;
			}
		}
		userAuditLog.usersAudit_Export_Button.click();
		if(!userAuditLog.usersAudit_Table.isDisplayed()){
			return false;
		}
		userAuditLog.usersAudit_Reset_Button.click();
		if(!userAuditLog.usersAudit_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean controlTables_Regions() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		controlTables = new Admin_ControlTables();
		String CTR_Search = reader.getCellData("Search_Data", "CT_Region", 2);
		homePage.admin_Dropdown.click();
		commonMethods.clicklink("Control Tables");
		controlTables.controlTables_Search_TextBox.sendKeys(CTR_Search);
		controlTables.controlTables_Go_Button.click();
		Thread.sleep(1000);
		int noofRowsCTR = driver.findElements(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabRegion_gvRegion_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsCTR-1;i++) {
			String verifyRegionName = driver.findElement(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabRegion_gvRegion_gv']/tbody/tr["+(i+1)+"]/td["+i+"]")).getText();
			if(!verifyRegionName.contains(CTR_Search)) {
				return false;
			}
		}
		controlTables.controlTables_Export_Button.click();
		if(!controlTables.controlTables_Table.isDisplayed()){
			return false;
		}
		controlTables.controlTables_Reset_Button.click();
		if(!controlTables.controlTables_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean controlTables_Areas() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		controlTables = new Admin_ControlTables();
		String CTA_Search = reader.getCellData("Search_Data", "CT_Area", 2);
		homePage.admin_Dropdown.click();
		commonMethods.clicklink("Control Tables");
		controlTables.controlTables_Areas_Button.click();
		Thread.sleep(1000);
		controlTables.controlTables_Search_TextBox.sendKeys(CTA_Search);
		controlTables.controlTables_Go_Button.click();
		int noofRowsCTA = driver.findElements(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabArea_gvArea_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsCTA-1;i++) {
			String verifyAreaName = driver.findElement(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabArea_gvArea_gv']/tbody/tr["+(i+1)+"]/td["+(i+1)+"]")).getText();
			if(!verifyAreaName.contains(CTA_Search)) {
				return false;
			}
		}
		
		controlTables.controlTables_Reset_Button.click();
		if(!controlTables.controlTables_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean controlTables_Market() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		controlTables = new Admin_ControlTables();
		String CTM_Search = reader.getCellData("Search_Data", "CT_Market", 2);
		homePage.admin_Dropdown.click();
		commonMethods.clicklink("Control Tables");
		controlTables.controlTables_Market_Button.click();
		Thread.sleep(1000);
		controlTables.controlTables_Search_TextBox.sendKeys(CTM_Search);
		controlTables.controlTables_Go_Button.click();
		int noofRowsCTM = driver.findElements(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabMarket_gvMarket_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsCTM-1;i++) {
			String verifyMarketName = driver.findElement(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabMarket_gvMarket_gv']/tbody/tr["+(i+1)+"]/td["+i+"]")).getText();
			if(!verifyMarketName.contains(CTM_Search)) {
				return false;
			}
		}
		
		controlTables.controlTables_Reset_Button.click();
		if(!controlTables.controlTables_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean controlTables_Project() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		controlTables = new Admin_ControlTables();
		String CTP_Search = reader.getCellData("Search_Data", "CT_Project", 2);
		homePage.admin_Dropdown.click();
		commonMethods.clicklink("Control Tables");
		controlTables.controlTables_Project_Button.click();
		Thread.sleep(1000);
		controlTables.controlTables_Search_TextBox.sendKeys(CTP_Search);
		controlTables.controlTables_Go_Button.click();
		int noofRowsCTP = driver.findElements(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabProject_gvProject_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsCTP-1;i++) {
			String verifyProjectName = driver.findElement(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabProject_gvProject_gv']/tbody/tr["+(i+1)+"]/td["+i+"]")).getText();
			if(!verifyProjectName.contains(CTP_Search)) {
				return false;
			}
		}
		
		controlTables.controlTables_Reset_Button.click();
		if(!controlTables.controlTables_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean regionsAreasMarket() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		adminRAM = new Admin_Regions_Areas_Market();
		String RAM_Search = reader.getCellData("Search_Data", "Region/Area/Market", 2);
		homePage.admin_Dropdown.click();
		commonMethods.clicklink("Region/Area/Market");
		adminRAM.ram_Search_Textbox.sendKeys(RAM_Search);
		adminRAM.ram_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsRAM = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsRAM-1;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[5]")).getText();
			if(!verifyMarket.equals(RAM_Search)) {
				return false;
			}
		}
		adminRAM.ram_Export_Button.click();
		if(!adminRAM.ram_Table.isDisplayed()){
			return false;
		}
		adminRAM.ram_Reset_Button.click();
		boolean adminRAMTableDisplayed;
		if(adminRAMTableDisplayed = adminRAM.ram_Table.isDisplayed()) {
			return adminRAMTableDisplayed;
		}
		return true;
	}
	
	public boolean marketProject() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		adminMP = new Admin_Market_Project();
		String MP_Search = reader.getCellData("Search_Data", "Market/Project", 2);
		homePage.admin_Dropdown.click();
		commonMethods.clicklink("Market/Project");
		adminMP.mp_Search_TextBox.sendKeys(MP_Search);
		adminMP.mp_Go_Button.click();
		Thread.sleep(3000);
		int noofRowsMP = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsMP-1;i++) {
			String verifyProject = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td["+i+"]")).getText();
			if(!verifyProject.equals(MP_Search)) {
				return false;
			}
		}
		adminMP.mp_Export_Button.click();
		if(!adminMP.mp_Table.isDisplayed()){
			return false;
		}
		adminMP.mp_Reset_Button.click();
		if(!adminMP.mp_Table.isDisplayed()){
			return false;
		}
		return true;
	}
	
	public boolean partMaster() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		partmaster = new Admin_PartMaster();
		String PM_Search = reader.getCellData("Search_Data", "Part_Master", 2);
		homePage.admin_Dropdown.click();
		commonMethods.clicklink("Part Master");
		partmaster.partMaster_Search_TextBox.sendKeys(PM_Search);
		partmaster.partMaster_Go_Button.click();
		Thread.sleep(1000);
		int noofRowsPM = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsPM-1;i++) {
			String verifyUsername = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[2]")).getText();
			if(!verifyUsername.equals(PM_Search)) {
				return false;
			}
		}
		partmaster.partMaster_Export_Button.click();
		if(!partmaster.partMaster_Table.isDisplayed()){
			return false;
		}
		partmaster.partMaster_Reset_Button.click();
		if(!partmaster.partMaster_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean partMaintenance() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		partmaintian = new Admin_PartMaintenance();
		String PME_Search = reader.getCellData("Search_Data", "Part_Maintenance", 2);
		homePage.admin_Dropdown.click();
		commonMethods.clicklink("Part Maintenance");
		partmaintian.partMaintenance_Search_TextBox.sendKeys(PME_Search);
		partmaintian.partMaintenance_Go_Button.click();
		Thread.sleep(1000);
		int noofRowsPME = driver.findElements(By.xpath("//table[@id = 'MainContent_gvPart_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRowsPME-1;i++) {
			String verifySAP = driver.findElement(By.xpath("//table[@id = 'MainContent_gvPart_gv']/tbody/tr["+(i+1)+"]/td[1]")).getText();
			if(!verifySAP.equals(PME_Search)) {
				return false;
			}
		}
		partmaintian.partMaintenance_Export_Button.click();
		if(!partmaintian.partMaintenance_Table.isDisplayed()){
			return false;
		}
		partmaintian.partMaintenance_Reset_Button.click();
		if(!partmaintian.partMaintenance_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean adminWarehouse() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		adminWarehouse = new Admin_Warehouse();
		String Warehouse_Search = reader.getCellData("Search_Data", "Warehouse", 2);
		homePage.admin_Dropdown.click();
		commonMethods.clicklink("Warehouse/Location");
		adminWarehouse.warehouse_Search_TextBox.sendKeys(Warehouse_Search);
		adminWarehouse.warehouse_Go_Button.click();
		Thread.sleep(1000);
		int noofRowWW = driver.findElements(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabWarehouse_gvWarehouse']/tbody/tr")).size();
		for(int i=1;i<=noofRowWW-1;i++) {
			String verifyWarehouseName = driver.findElement(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabWarehouse_gvWarehouse']/tbody/tr["+(i+1)+"]/td[2]")).getText();
			if(!verifyWarehouseName.equals(Warehouse_Search)) {
				return false;
			}
		}
		adminWarehouse.warehouse_Export_Button.click();
		if(!adminWarehouse.warehouse_Table.isDisplayed()){
			return false;
		}
		adminWarehouse.warehouse_Reset_Button.click();
		if(!adminWarehouse.warehouse_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean adminWarehouse_Location() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		adminWarehouse = new Admin_Warehouse();
		String WarehouseLocation_Search = reader.getCellData("Search_Data", "Warehouse_Location", 2);
		homePage.admin_Dropdown.click();
		commonMethods.clicklink("Warehouse/Location");
		adminWarehouse.warehouse_Locatios_Button.click();
		Thread.sleep(1000);
		adminWarehouse.warehouse_Search_TextBox.sendKeys(WarehouseLocation_Search);
		adminWarehouse.warehouse_Go_Button.click();
		Thread.sleep(1000);
		int noofRowWL = driver.findElements(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabStorage_gvStorage']/tbody/tr")).size();
		for(int i=1;i<=noofRowWL-1;i++) {
			String verifyLocationName = driver.findElement(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabStorage_gvStorage']/tbody/tr["+(i+1)+"]/td[2]")).getText();
			if(!verifyLocationName.equals(WarehouseLocation_Search)) {
				return false;
			}
		}
		
		adminWarehouse.warehouse_Reset_Button.click();
		if(!adminWarehouse.warehouse_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean adminWarehouse_Zones() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		adminWarehouse = new Admin_Warehouse();
		String WarehouseLocation_Zone = reader.getCellData("Search_Data", "Warehouse_Zone", 2);
		homePage.admin_Dropdown.click();
		commonMethods.clicklink("Warehouse/Location");
		adminWarehouse.warehouse_Zones_Button.click();
		Thread.sleep(1000);
		adminWarehouse.warehouse_Search_TextBox.sendKeys(WarehouseLocation_Zone);
		adminWarehouse.warehouse_Go_Button.click();
		Thread.sleep(1000);
		int noofRowWZN = driver.findElements(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabZone_gvZones']/tbody/tr")).size();
		for(int i=1;i<=noofRowWZN-1;i++) {
			String verifyZoneName = driver.findElement(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabZone_gvZones']/tbody/tr["+(i+1)+"]/td[3]")).getText();
			if(!verifyZoneName.equals(WarehouseLocation_Zone)) {
				return false;
			}
		}
		adminWarehouse.warehouse_Reset_Button.click();
		if(!adminWarehouse.warehouse_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean adminSerialManagement() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		adminSerialM = new Admin_SerialManagement();
		String SerialManagement_Zone = reader.getCellData("Search_Data", "Serial_Management", 2);
		homePage.admin_Dropdown.click();
		commonMethods.clicklink("Serial Management");
		adminSerialM.serialManagement_Search_TextBox.sendKeys(SerialManagement_Zone);
		adminSerialM.serialManagement_Go_Button.click();
		Thread.sleep(1000);
		int noofRowsSM = driver.findElements(By.xpath("//table[@id = 'MainContent_gvSerialList']/tbody/tr")).size();
		for(int i=1;i<=noofRowsSM-1;i++) {
			String verifyUsername = driver.findElement(By.xpath("//table[@id = 'MainContent_gvSerialList']/tbody/tr["+(i+1)+"]/td["+(i+2)+"]")).getText();
			if(!verifyUsername.equals(SerialManagement_Zone)) {
				return false;
			}
		}
		adminSerialM.serialManagement_Reset_Button.click();
		if(!adminSerialM.serialManagement_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean adminReasonCodes() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		adminReasonCodes = new Admin_ReasonCodes();
		homePage.admin_Dropdown.click();
		Thread.sleep(1000);
		commonMethods.jsClick(driver.findElement(By.linkText("Reason Codes")));
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'ctl00$MainContent$ddlLookupGroupChoice']")));
		select.selectByVisibleText("Deactivating BOM");
		Thread.sleep(1000);
		boolean adminReasonCodesTableDisplayed = adminReasonCodes.reasonCodes_Table.isDisplayed();
		return adminReasonCodesTableDisplayed;
	}
	
	public boolean adminAdjustmentReasonCodes() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		adminAdjustmentCodes= new Admin_AdjustmentCodes();
		homePage.admin_Dropdown.click();
		Thread.sleep(1000);
		commonMethods.jsClick(driver.findElement(By.linkText("Adjustment Codes")));
		boolean adminAdjustmentReasonCodesTableDisplayed = adminAdjustmentCodes.adjustmentReasonCodes_Table.isDisplayed();
		return adminAdjustmentReasonCodesTableDisplayed;
	}
}
