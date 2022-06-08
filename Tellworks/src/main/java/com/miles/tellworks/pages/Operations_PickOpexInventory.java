package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.miles.tellworks.mainmenu.TellworksBase;

public class Operations_PickOpexInventory extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement pickOpex_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement pickOpex_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_txtSearch']")
	public WebElement pickOpex_Search_TextBox;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement pickOpex_Reset_Button;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement pickOpex_Export_Button;
	
	public Operations_PickOpexInventory() {
		PageFactory.initElements(driver, this);
	}
}
