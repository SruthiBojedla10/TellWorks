package com.miles.tellworks.pagepanel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.miles.tellworks.excelutil.Xls_Reader;
import com.miles.tellworks.mainmenu.TellworksBase;
import com.miles.tellworks.pages.HomePage;
import com.miles.tellworks.pages.Receiving_ASNApproval;
import com.miles.tellworks.pages.Receiving_ASNManagement;
import com.miles.tellworks.pages.Receiving_ReceivingManagement;
import com.miles.tellworks.pages.Receiving_ReceivingReversals;

public class Receiving extends TellworksBase{

	HomePage homePage;
	CommonMethods commonMethods;
	Receiving_ASNManagement receivingASNManagement;
	Receiving_ASNApproval receivingASNApproval;
	Receiving_ReceivingManagement receivingManagement;
	Receiving_ReceivingReversals receivingReversals;
	
	Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "\\TestData\\Tellworks_Data.xlsx");
	
	public boolean ASNManagement() throws InterruptedException {

		homePage = new HomePage();
		commonMethods = new CommonMethods();
		receivingASNManagement = new Receiving_ASNManagement();
		String filter_Search = reader.getCellData("Receiving_Data", "SourceType", 2);
		homePage.receiving_Dropdown.click();
		commonMethods.jsClick(driver.findElement(By.xpath("//a[contains(text(),'ASN Management')]")));
		Select select = new Select(driver.findElement(By.xpath("//select[@id = 'MainContent_ddlSAASNSourceTypes']")));
		select.selectByVisibleText(filter_Search);
		receivingASNManagement.asnm_Go_Button.click();
		int noofRows = driver.findElements(By.xpath("//table[@id = 'MainContent_gvSAASNList']/tbody/tr")).size();
		for(int i=1;i<=noofRows-2;i++) {
			String verifySource = driver.findElement(By.xpath("//table[@id = 'MainContent_gvSAASNList']/tbody/tr["+(i+1)+"]/td[3]")).getText();
			if(!verifySource.equals(filter_Search)) {
				return false;
			}
		}
		receivingASNManagement.asnm_Export_Button.click();
		if(!receivingASNManagement.asnm_Table.isDisplayed()){
			return false;
		}
		receivingASNManagement.asnm_Reset_Button.click();
		if(!receivingASNManagement.asnm_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean ASNApproval() throws InterruptedException {

		homePage = new HomePage();
		commonMethods = new CommonMethods();
		receivingASNApproval = new Receiving_ASNApproval();
		String Status_Search = reader.getCellData("Receiving_Data", "ApprovalStatus", 2);
		homePage.receiving_Dropdown.click();
		commonMethods.jsClick(driver.findElement(By.xpath("//a[contains(text(),'ASN Approvals')]")));
		Select select = new Select(driver.findElement(By.xpath("//select[@id = 'MainContent_ddlFilterApprovalStatus']")));
		select.selectByVisibleText(Status_Search);
		receivingASNApproval.asna_Go_Button.click();
		int noofRows = driver.findElements(By.xpath("//table[@id = 'MainContent_gvSAASNList']/tbody/tr")).size();
		for(int i=1;i<=noofRows-2;i++) {
			String verifyStatus = driver.findElement(By.xpath("//table[@id = 'MainContent_gvSAASNList']/tbody/tr["+(i+1)+"]/td[5]")).getText();
			if(!verifyStatus.equals(Status_Search)) {
				return false;
			}
		}
		receivingASNApproval.asna_Reset_Button.click();
		if(!receivingASNApproval.asna_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean ReceivingManagement() throws InterruptedException {

		homePage = new HomePage();
		commonMethods = new CommonMethods();
		receivingManagement = new Receiving_ReceivingManagement();
		String Market_Search = reader.getCellData("Receiving_Data", "Market", 2);
		homePage.receiving_Dropdown.click();
		commonMethods.jsClick(driver.findElement(By.xpath("//a[contains(text(),'Receiving Management')]")));
		Select select = new Select(driver.findElement(By.xpath("//select[@id = 'MainContent_GridHeader_ddlMarket']")));
		select.selectByVisibleText(Market_Search);
		receivingManagement.receivingManagement_Go_Button.click();
		int noofRows = driver.findElements(By.xpath("//table[@id = 'MainContent_gv_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRows-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gv_gv']/tbody/tr["+(i+1)+"]/td[5]")).getText();
			if(!verifyMarket.equals(Market_Search)) {
				return false;
			}
		}
		receivingManagement.receivingManagement_Export_Button.click();
		if(!receivingManagement.receivingManagement_Table.isDisplayed()){
			return false;
		}
		receivingManagement.receivingManagement_Reset_Button.click();
		if(!receivingManagement.receivingManagement_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
	
	public boolean ReceivingReversals() throws InterruptedException {

		homePage = new HomePage();
		commonMethods = new CommonMethods();
		receivingReversals = new Receiving_ReceivingReversals();
		String Status_Search = reader.getCellData("Receiving_Data", "Statuses", 2);
		homePage.receiving_Dropdown.click();
		commonMethods.jsClick(driver.findElement(By.xpath("//a[contains(text(),'Receiving Reversals')]")));
		Select select = new Select(driver.findElement(By.xpath("//select[@id = 'MainContent_ddlPOStatus']")));
		select.selectByVisibleText(Status_Search);
		receivingReversals.receivingReversals_Go_Button.click();
		int noofRows = driver.findElements(By.xpath("//table[@id = 'MainContent_gvPOReversalsList']/tbody/tr")).size();
		for(int i=1;i<=noofRows-2;i++) {
			String verifyMarket = driver.findElement(By.xpath("//table[@id = 'MainContent_gvPOReversalsList']/tbody/tr["+(i+1)+"]/td[13]")).getText();
			if(!verifyMarket.equals(Status_Search)) {
				return false;
			}
		}
		receivingReversals.receivingReversals_Export_Button.click();
		if(!receivingReversals.receivingReversals_Table.isDisplayed()){
			return false;
		}
		receivingReversals.receivingReversals_Reset_Button.click();
		if(!receivingReversals.receivingReversals_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
}
