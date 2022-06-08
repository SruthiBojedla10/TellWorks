package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Inventory_PartMaster extends TellworksBase{

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement partMaster_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement partMaster_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_txtSearch']")
	public WebElement partMaster_Search_TextBox;	
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement partMaster_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement partMaster_Reset_Message;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement partMaster_Export_Button;
	
	public Inventory_PartMaster() {
		PageFactory.initElements(driver, this);
	}
}
