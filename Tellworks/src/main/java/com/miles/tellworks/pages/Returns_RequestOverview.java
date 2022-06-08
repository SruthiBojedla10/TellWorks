package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Returns_RequestOverview extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement ReturnsRO_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement ReturnsRO_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement ReturnsRO_Reset_Button;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement ReturnsRO_Export_Button;
	
	public Returns_RequestOverview() {
		PageFactory.initElements(driver, this);
	}
}
