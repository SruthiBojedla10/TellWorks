package com.miles.tellworks.pagepanel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.miles.tellworks.excelutil.Xls_Reader;
import com.miles.tellworks.mainmenu.TellworksBase;
import com.miles.tellworks.pages.HomePage;
import com.miles.tellworks.pages.Operations_OpexInventory;
import com.miles.tellworks.pages.Operations_PickOpexInventory;

public class Operations extends TellworksBase {

	HomePage homePage;
	CommonMethods commonMethods;
	Operations_OpexInventory operationsOI;
	Operations_PickOpexInventory operationsPickOI;
	int noofRows;
	
	Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "\\TestData\\Tellworks_Data.xlsx");
	String operations_Search = reader.getCellData("Search_Data", "Operations_Search", 2);
	
	public boolean OpexInventory() throws InterruptedException {

		homePage = new HomePage();
		commonMethods = new CommonMethods();
		operationsOI = new Operations_OpexInventory();
		String filter_Search = reader.getCellData("Search_Data", "Operations_Filter", 2);
		homePage.operations_Dropdown.click();
		commonMethods.clicklink("OPEX Inventory");
		Select select = new Select(driver.findElement(By.xpath("//select[@id = 'MainContent_UserFilter_ddlMarketList']")));
		select.selectByVisibleText(filter_Search);
		Thread.sleep(7000);
		operationsOI.opex_Go_Button.click();
		Thread.sleep(1000);
		noofRows = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRows-1;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[5]")).getText();
			if(!verifyMarket.equals(filter_Search)) {
				return false;
			}
		}
		operationsOI.opex_Export_Button.click();
		if(!operationsOI.opex_Table.isDisplayed()){
			return false;
		}
		operationsOI.opex_Reset_Button.click();
		if(!operationsOI.opex_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}

	public boolean PickOpexInventory() throws InterruptedException {

		homePage = new HomePage();
		commonMethods = new CommonMethods();
		operationsPickOI = new Operations_PickOpexInventory();
		homePage.operations_Dropdown.click();
		commonMethods.clicklink("Pick OPEX Inventory");
		operationsPickOI.pickOpex_Search_TextBox.sendKeys(operations_Search);
		operationsPickOI.pickOpex_Go_Button.click();
		Thread.sleep(1000);
		noofRows = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRows-1;i++) {
			String verifySAP = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[3]")).getText();
			if(!verifySAP.equals(operations_Search)) {
				return false;
			}
		}
		operationsPickOI.pickOpex_Export_Button.click();
		if(!operationsPickOI.pickOpex_Table.isDisplayed()){
			return false;
		}
		operationsPickOI.pickOpex_Reset_Button.click();
		if(!operationsPickOI.pickOpex_Table.isDisplayed()) {
			return false;
		}
		return true;
	}
}
