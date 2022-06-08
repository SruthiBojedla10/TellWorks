package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Support_ChartTransfer extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbSearch']")
	public WebElement supportCTR_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvTransfers']")
	public WebElement supportCTR_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbReset']")
	public WebElement supportCTR_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement supportCTR_Reset_Message;
	
	public Support_ChartTransfer() {
		PageFactory.initElements(driver, this);
	}
}
