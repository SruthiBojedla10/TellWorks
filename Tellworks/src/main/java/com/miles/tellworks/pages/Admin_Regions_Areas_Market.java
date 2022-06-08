package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.miles.tellworks.mainmenu.TellworksBase;

public class Admin_Regions_Areas_Market extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_txtSearch']")
	public WebElement ram_Search_Textbox;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement ram_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement ram_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement ram_Reset_Button;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement ram_Export_Button;
	
	public Admin_Regions_Areas_Market() {
		PageFactory.initElements(driver, this);
	}

}
