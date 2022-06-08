package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Returns_UserApproverAssignment extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_txtSearch']")
	public WebElement ReturnsUAA_Search_TextBox;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement ReturnsUAA_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_tabContainerMain_tabApprovers_gvApprovers']")
	public WebElement ReturnsUAA_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement ReturnsUAA_Reset_Button;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement ReturnsUAA_Export_Button;
	
	public Returns_UserApproverAssignment() {
		PageFactory.initElements(driver, this);
	}
}
