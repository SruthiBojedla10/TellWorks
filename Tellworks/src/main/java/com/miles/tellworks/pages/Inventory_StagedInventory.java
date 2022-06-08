package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.miles.tellworks.mainmenu.TellworksBase;

public class Inventory_StagedInventory extends TellworksBase{

	@FindBy(xpath = "//input[@id = 'MainContent_GridFilter_lbSearch']")
	public WebElement stagedInventory_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvInventory']")
	public WebElement stagedInventory_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_GridFilter_txtSearch']")
	public WebElement stagedInventory_Search_TextBox;	
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridFilter_lbReset']")
	public WebElement stagedInventory_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement stagedInventory_Reset_Message;

	@FindBy(xpath = "//input[@id = 'MainContent_GridFilter_lbExport']")
	public WebElement stagedInventory_Export_Button;
	
	public Inventory_StagedInventory() {
		PageFactory.initElements(driver, this);
	}
}
