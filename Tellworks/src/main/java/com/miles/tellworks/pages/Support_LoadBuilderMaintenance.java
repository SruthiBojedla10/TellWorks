package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Support_LoadBuilderMaintenance extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbSearch']")
	public WebElement supportLBM_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvInventory']")
	public WebElement supportLBM_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbReset']")
	public WebElement supportLBM_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement supportLBM_Reset_Message;
	
	public Support_LoadBuilderMaintenance() {
		PageFactory.initElements(driver, this);
	}
}
