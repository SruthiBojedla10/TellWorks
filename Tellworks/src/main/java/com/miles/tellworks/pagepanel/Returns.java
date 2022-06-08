package com.miles.tellworks.pagepanel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.miles.tellworks.excelutil.Xls_Reader;
import com.miles.tellworks.mainmenu.TellworksBase;
import com.miles.tellworks.pages.HomePage;
import com.miles.tellworks.pages.Returns_RequestOverview;
import com.miles.tellworks.pages.Returns_UserApproverAssignment;
import com.miles.tellworks.pages.Returns_WorkflowMaintenance;

public class Returns extends TellworksBase{

	HomePage homePage;
	CommonMethods commonMethods;
	Returns_RequestOverview requestOverview;
	Returns_UserApproverAssignment userApproverAssignment;
	Returns_WorkflowMaintenance workflowMaintenance; 
	
	Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "\\TestData\\Tellworks_Data.xlsx");
	
	public boolean ReturnsRequestOverview() throws InterruptedException {

		homePage = new HomePage();
		commonMethods = new CommonMethods();
		requestOverview = new Returns_RequestOverview();
		String Project_Search = reader.getCellData("Receiving_Data", "ReturnProject_Search", 2);
		homePage.returns_Dropdown.click();
		commonMethods.clicklink("Return Requests Overview");
		Select select = new Select(driver.findElement(By.xpath("//select[@id = 'MainContent_GridHeader_ddlProjectList']")));
		select.selectByVisibleText(Project_Search);
		Thread.sleep(3000);
		requestOverview.ReturnsRO_Go_Button.click();
		int noofRows = driver.findElements(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr")).size();
		for(int i=1;i<=noofRows-1;i++) {
			String verifyProject = driver.findElement(By.xpath("//table[@id = 'MainContent_gv']/tbody/tr["+(i+1)+"]/td[5]")).getText();
			if(!verifyProject.equals(Project_Search)) {
				return false;
			}
		}
//		Thread.sleep(3000);
//		requestOverview.ReturnsRO_Export_Button.click();
//		if(!requestOverview.ReturnsRO_Table.isDisplayed()){
//			return false;
//		}
		Thread.sleep(3000);
		requestOverview.ReturnsRO_Reset_Button.click();
		if(!requestOverview.ReturnsRO_Table.isDisplayed()) {
			return false;
		}
		return true;
	}
	
	public boolean ReturnsWorkflowMaintenance() throws InterruptedException {

		homePage = new HomePage();
		commonMethods = new CommonMethods();
		workflowMaintenance = new Returns_WorkflowMaintenance();
		String RuleName_Search = reader.getCellData("Receiving_Data", "RuleName_Search", 2);
		homePage.returns_Dropdown.click();
		commonMethods.clicklink("Workflow Maintenance");
		workflowMaintenance.ReturnsWM_Search_TextBox.sendKeys(RuleName_Search);
		Thread.sleep(3000);
		workflowMaintenance.ReturnsWM_Go_Button.click();
		int noofRows = driver.findElements(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabWorkflows_gvWorkflows']/tbody/tr")).size();
		for(int i=1;i<=noofRows-1;i++) {
			String verifyProject = driver.findElement(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabWorkflows_gvWorkflows']/tbody/tr["+(i+1)+"]/td[2]")).getText();
			if(!verifyProject.equals(RuleName_Search)) {
				return false;
			}
		}
		Thread.sleep(3000);
		workflowMaintenance.ReturnsWM_Export_Button.click();
		if(!workflowMaintenance.ReturnsWM_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(3000);
		workflowMaintenance.ReturnsWM_Reset_Button.click();
		if(!workflowMaintenance.ReturnsWM_Table.isDisplayed()) {
			return false;
		}
		return true;
	}
	
	public boolean ReturnsUserApproverAssignment() throws InterruptedException {

		homePage = new HomePage();
		commonMethods = new CommonMethods();
		userApproverAssignment = new Returns_UserApproverAssignment();
		String Project_Search = reader.getCellData("Receiving_Data", "UAAProject_Search", 2);
		homePage.returns_Dropdown.click();
		commonMethods.clicklink("User Approver Assignment");
		userApproverAssignment.ReturnsUAA_Search_TextBox.sendKeys(Project_Search);
		userApproverAssignment.ReturnsUAA_Go_Button.click();
		Thread.sleep(3000);
		int noofRows = driver.findElements(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabApprovers_gvApprovers']/tbody/tr")).size();
		for(int i=1;i<=noofRows-1;i++) {
			String verifyProject = driver.findElement(By.xpath("//table[@id = 'MainContent_tabContainerMain_tabApprovers_gvApprovers']/tbody/tr["+(i+1)+"]/td[6]")).getText();
			if(!verifyProject.equals(Project_Search)) {
				return false;
			}
		}
		Thread.sleep(3000);
		userApproverAssignment.ReturnsUAA_Export_Button.click();
		if(!userApproverAssignment.ReturnsUAA_Table.isDisplayed()){
			return false;
		}
		Thread.sleep(3000);
		userApproverAssignment.ReturnsUAA_Reset_Button.click();
		if(!userApproverAssignment.ReturnsUAA_Table.isDisplayed()) {
			return false;
		}
		return true;
	}
}
