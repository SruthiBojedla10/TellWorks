package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Support_OutboundMonitor extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_PickFilter_lbSearch']")
	public WebElement supportOM_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement supportOM_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_PickFilter_lbReset']")
	public WebElement supportOM_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement supportOM_Reset_Message;
	
	@FindBy(xpath = "//input[@id = 'MainContent_PickFilter_lbExport']")
	public WebElement supportOM_Export_Button;
	
	public Support_OutboundMonitor() {
		PageFactory.initElements(driver, this);
	}
}
