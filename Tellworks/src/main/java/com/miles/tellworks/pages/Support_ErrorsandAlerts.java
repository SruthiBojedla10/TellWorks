package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Support_ErrorsandAlerts extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement supportEA_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement supportEA_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement supportEA_Reset_Button;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement supportEA_Export_Button;
	
	public Support_ErrorsandAlerts() {
		PageFactory.initElements(driver, this);
	}
}
