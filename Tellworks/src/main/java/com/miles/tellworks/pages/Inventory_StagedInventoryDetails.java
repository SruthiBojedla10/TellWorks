package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.miles.tellworks.mainmenu.TellworksBase;

public class Inventory_StagedInventoryDetails extends TellworksBase{

	@FindBy(xpath = "//input[@id = 'MainContent_GridFilter_lbSearch']")
	public WebElement stagedInventoryDetails_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvInventory']")
	public WebElement stagedInventoryDetails_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_GridFilter_ddlMarketList']")
	public WebElement stagedInventoryDetails_Search_TextBox;	
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridFilter_lbReset']")
	public WebElement stagedInventoryDetails_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement stagedInventoryDetails_Reset_Message;	
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridFilter_lbExport']")
	public WebElement stagedInventoryDetails_Export_Button;
	
	public Inventory_StagedInventoryDetails() {
		PageFactory.initElements(driver, this);
	}
}
