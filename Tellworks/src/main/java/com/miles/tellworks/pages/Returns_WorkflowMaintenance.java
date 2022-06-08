package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Returns_WorkflowMaintenance extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_txtSearch']")
	public WebElement ReturnsWM_Search_TextBox;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement ReturnsWM_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_tabContainerMain_tabWorkflows_gvWorkflows']")
	public WebElement ReturnsWM_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement ReturnsWM_Reset_Button;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement ReturnsWM_Export_Button;
	
	public Returns_WorkflowMaintenance() {
		PageFactory.initElements(driver, this);
	}
}
