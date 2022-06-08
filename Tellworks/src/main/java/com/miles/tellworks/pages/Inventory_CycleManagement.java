package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Inventory_CycleManagement extends TellworksBase{

	@FindBy(xpath = "//input[@id = 'MainContent_lbSearch']")
	public WebElement cycleCountManagement_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvList']")
	public WebElement cycleCountManagement_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_txtSearch']")
	public WebElement cycleCountManagement_Search_TextBox;	
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbReset']")
	public WebElement cycleCountManagement_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement cycleCountManagement_Reset_Message;
	
	public Inventory_CycleManagement() {
		PageFactory.initElements(driver, this);
	}
}
