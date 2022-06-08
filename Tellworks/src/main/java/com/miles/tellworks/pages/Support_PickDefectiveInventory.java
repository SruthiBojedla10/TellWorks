package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Support_PickDefectiveInventory extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement supportPDI_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement supportPDI_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement supportPDI_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement supportPDI_Reset_Message;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement supportPDI_Export_Button;
	
	public Support_PickDefectiveInventory() {
		PageFactory.initElements(driver, this);
	}
}
