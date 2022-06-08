package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class DigitalLayer_Corrections extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbSearch']")
	public WebElement digitalLC_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvDigitalLayerFailedTransactions']")
	public WebElement digitalLC_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbReset']")
	public WebElement digitalLC_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_pnlEnterSearchQuery']")
	public WebElement digitalLC_Reset_Message;
	
	public DigitalLayer_Corrections() {
		PageFactory.initElements(driver, this);
	}
}
