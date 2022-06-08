package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.miles.tellworks.mainmenu.TellworksBase;

public class Inventory_Shipped extends TellworksBase{

	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_txtSearch']")
	public WebElement shipped_search_Button;
	
	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbSearch']")
	public WebElement shipped_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement shipped_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbReset']")
	public WebElement shipped_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement shipped_Reset_Message;	
		
	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbExport']")
	public WebElement shipped_Export_Button;
	
	public Inventory_Shipped() {
		PageFactory.initElements(driver, this);
	}
}
