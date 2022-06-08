package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.miles.tellworks.mainmenu.TellworksBase;

public class Inventory_Received extends TellworksBase{

	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbSearch']")
	public WebElement received_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement received_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbReset']")
	public WebElement received_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement received_Reset_Message;
	
	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbExport']")
	public WebElement received_Export_Button;
	
	public Inventory_Received() {
		PageFactory.initElements(driver, this);
	}
}
