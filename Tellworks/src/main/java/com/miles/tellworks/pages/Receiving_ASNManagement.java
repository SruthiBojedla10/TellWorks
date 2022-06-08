package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Receiving_ASNManagement extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbSearch']")
	public WebElement asnm_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvSAASNList']")
	public WebElement asnm_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbReset']")
	public WebElement asnm_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement asnm_Reset_Message;
	
	@FindBy(xpath = "//input[@id = 'MainContent_btnExport']")
	public WebElement asnm_Export_Button;
	
	public Receiving_ASNManagement() {
		PageFactory.initElements(driver, this);
	}
}
