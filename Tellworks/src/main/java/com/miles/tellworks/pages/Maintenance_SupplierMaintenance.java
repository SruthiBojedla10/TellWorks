package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Maintenance_SupplierMaintenance extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_txtSearch']")
	public WebElement mSM_Search_TextBox;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement mSM_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvSupplier']")
	public WebElement mSM_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement mSM_Reset_Button;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement mSM_Export_Button;
	
	public Maintenance_SupplierMaintenance() {
		PageFactory.initElements(driver, this);
	}
}
