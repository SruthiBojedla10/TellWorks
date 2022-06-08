package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.miles.tellworks.mainmenu.TellworksBase;

public class Admin_ControlTables extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_txtSearch']")
	public WebElement controlTables_Search_TextBox;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement controlTables_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_tabContainerMain_tabRegion_gvRegion_gv']")
	public WebElement controlTables_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement controlTables_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_tabContainerMain_tabRegion_divEnterQueryMessageRegion']")
	public WebElement controlTables_Reset_Message;
	
	@FindBy(xpath = "//span[@id = 'MainContent_tabContainerMain_tabArea_tab']")
	public WebElement controlTables_Areas_Button;
	
	@FindBy(xpath = "//span[@id = 'MainContent_tabContainerMain_tabMarket_tab']")
	public WebElement controlTables_Market_Button;

	@FindBy(xpath = "//span[@id = 'MainContent_tabContainerMain_tabProject_tab']")
	public WebElement controlTables_Project_Button;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement controlTables_Export_Button;
	
	public Admin_ControlTables() {
		PageFactory.initElements(driver, this);
	}
}
