package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Support_ASNManagement extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbSearch']")
	public WebElement supportASNM_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvSAASNList']")
	public WebElement supportASNM_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbReset']")
	public WebElement supportASNM_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement supportASNM_Reset_Message;
	
	@FindBy(xpath = "//input[@id = 'MainContent_btnExport']")
	public WebElement supportASNM_Export_Button;
	
	public Support_ASNManagement() {
		PageFactory.initElements(driver, this);
	}
}
