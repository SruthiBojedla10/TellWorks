package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Support_InventoryManagement extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridFilter_lbSearch']")
	public WebElement supportIM_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvInventory']")
	public WebElement supportIM_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridFilter_lbReset']")
	public WebElement supportIM_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement supportIM_Reset_Message;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridFilter_lbExport']")
	public WebElement supportIM_Export_Button;
	
	public Support_InventoryManagement() {
		PageFactory.initElements(driver, this);
	}
}
