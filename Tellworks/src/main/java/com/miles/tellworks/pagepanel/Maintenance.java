package com.miles.tellworks.pagepanel;

import org.openqa.selenium.By;
import com.miles.tellworks.excelutil.Xls_Reader;
import com.miles.tellworks.mainmenu.TellworksBase;
import com.miles.tellworks.pages.HomePage;
import com.miles.tellworks.pages.Maintenance_PartMaintenance;
import com.miles.tellworks.pages.Maintenance_SupplierMaintenance;
import com.miles.tellworks.pages.Maintenance_WareHouse_Location;

public class Maintenance extends TellworksBase{

	HomePage homePage;
	CommonMethods commonMethods;
	Maintenance_PartMaintenance partMaintenance;
	Maintenance_SupplierMaintenance supplierMaintenance;
	Maintenance_WareHouse_Location maintenanceWarehouseLocation;
	
	Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "\\TestData\\Tellworks_Data.xlsx");
	
	public boolean PartMaintenance() {

		homePage = new HomePage();
		commonMethods = new CommonMethods();
		partMaintenance = new Maintenance_PartMaintenance();
		String SAP_Search = reader.getCellData("Receiving_Data", "Maintenance_Search", 2);
		homePage.maintenance_Dropdown.click();
		commonMethods.jsClick(driver.findElement(By.xpath("//a[contains(text(),'Part Maintenance')]")));
		partMaintenance.mPM_Search_TextBox.sendKeys(SAP_Search);
		partMaintenance.mPM_Go_Button.click();
		int noofRows = driver.findElements(By.xpath("//table[@id = 'MainContent_gvPart_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRows-2;i++) {
			String verifySource = driver.findElement(By.xpath("//table[@id = 'MainContent_gvPart_gv']/tbody/tr["+(i+1)+"]/td[1]")).getText();
			if(!verifySource.equals(SAP_Search)) {
				return false;
			}
		}
		partMaintenance.mPM_Export_Button.click();
		if(!partMaintenance.mPM_Table.isDisplayed()){
			return false;
		}
		partMaintenance.mPM_Reset_Button.click();
		if(!partMaintenance.mPM_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean SupplierMaintenance() throws InterruptedException {

		homePage = new HomePage();
		commonMethods = new CommonMethods();
		supplierMaintenance = new Maintenance_SupplierMaintenance();
		String Supplier_Search = reader.getCellData("Receiving_Data", "Supplier_Search", 2);
		homePage.receiving_Dropdown.click();
		commonMethods.jsClick(driver.findElement(By.xpath("//a[contains(text(),'Supplier Maintenance')]")));
		supplierMaintenance.mSM_Search_TextBox.sendKeys(Supplier_Search);
		supplierMaintenance.mSM_Go_Button.click();
		Thread.sleep(2000);
		int noofRows = driver.findElements(By.xpath("//table[@id = 'MainContent_gvSupplier']/tbody/tr")).size();
		for(int i=1;i<=noofRows-1;i++) {
			String verifySource = driver.findElement(By.xpath("//table[@id = 'MainContent_gvSupplier']/tbody/tr["+(i+1)+"]/td[2]")).getText();
			if(!verifySource.equals(Supplier_Search)) {
				return false;
			}
		}
		supplierMaintenance.mSM_Export_Button.click();
		if(!supplierMaintenance.mSM_Table.isDisplayed()){
			return false;
		}
		supplierMaintenance.mSM_Reset_Button.click();
		if(!supplierMaintenance.mSM_Table.isDisplayed()) {
			return false;
		}
		return true;
	}
	
	public boolean maintenanceWarehouse() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		maintenanceWarehouseLocation = new Maintenance_WareHouse_Location();
		String Warehouse_Search = reader.getCellData("Receiving_Data", "Warehouse_Search", 2);
		homePage.admin_Dropdown.click();
		commonMethods.jsClick(driver.findElement(By.xpath("//a[contains(text(),'Warehouse/Location')]")));
		maintenanceWarehouseLocation.warehouse_Search_TextBox.sendKeys(Warehouse_Search);
		maintenanceWarehouseLocation.warehouse_Go_Button.click();
		Thread.sleep(1000);
		int noofRowWW = driver.findElements(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabWarehouse_gvWarehouse']/tbody/tr")).size();
		for(int i=1;i<=noofRowWW-1;i++) {
			String verifyWarehouseName = driver.findElement(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabWarehouse_gvWarehouse']/tbody/tr["+(i+1)+"]/td[2]")).getText();
			if(!verifyWarehouseName.equals(Warehouse_Search)) {
				return false;
			}
		}
		maintenanceWarehouseLocation.warehouse_Export_Button.click();
		if(!maintenanceWarehouseLocation.warehouse_Table.isDisplayed()){
			return false;
		}
		maintenanceWarehouseLocation.warehouse_Reset_Button.click();
		if(!maintenanceWarehouseLocation.warehouse_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean maintenanceWarehouse_Location() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		maintenanceWarehouseLocation = new Maintenance_WareHouse_Location();
		String WarehouseLocation_Search = reader.getCellData("Receiving_Data", "Location_Search", 2);
		homePage.admin_Dropdown.click();
		commonMethods.jsClick(driver.findElement(By.xpath("//a[contains(text(),'Warehouse/Location')]")));
		maintenanceWarehouseLocation.warehouse_Locatios_Button.click();
		Thread.sleep(1000);
		maintenanceWarehouseLocation.warehouse_Search_TextBox.sendKeys(WarehouseLocation_Search);
		maintenanceWarehouseLocation.warehouse_Go_Button.click();
		Thread.sleep(1000);
		int noofRowWL = driver.findElements(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabStorage_gvStorage']/tbody/tr")).size();
		for(int i=1;i<=noofRowWL-1;i++) {
			String verifyLocationName = driver.findElement(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabStorage_gvStorage']/tbody/tr["+(i+1)+"]/td[2]")).getText();
			if(!verifyLocationName.equals(WarehouseLocation_Search)) {
				return false;
			}
		}
		
		maintenanceWarehouseLocation.warehouse_Reset_Button.click();
		if(!maintenanceWarehouseLocation.warehouse_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean maintenanceWarehouse_Zones() throws InterruptedException {
		homePage = new HomePage(); 
		commonMethods = new CommonMethods();
		maintenanceWarehouseLocation = new Maintenance_WareHouse_Location();
		String WarehouseLocation_Zone = reader.getCellData("Receiving_Data", "Zone_Search", 2);
		homePage.admin_Dropdown.click();
		commonMethods.jsClick(driver.findElement(By.xpath("//a[contains(text(),'Warehouse/Location')]")));
		maintenanceWarehouseLocation.warehouse_Zones_Button.click();
		Thread.sleep(1000);
		maintenanceWarehouseLocation.warehouse_Search_TextBox.sendKeys(WarehouseLocation_Zone);
		maintenanceWarehouseLocation.warehouse_Go_Button.click();
		Thread.sleep(1000);
		int noofRowWZN = driver.findElements(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabZone_gvZones']/tbody/tr")).size();
		for(int i=1;i<=noofRowWZN-1;i++) {
			String verifyZoneName = driver.findElement(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabZone_gvZones']/tbody/tr["+(i+1)+"]/td[3]")).getText();
			if(!verifyZoneName.equals(WarehouseLocation_Zone)) {
				return false;
			}
		}
		maintenanceWarehouseLocation.warehouse_Reset_Button.click();
		if(!maintenanceWarehouseLocation.warehouse_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
}
