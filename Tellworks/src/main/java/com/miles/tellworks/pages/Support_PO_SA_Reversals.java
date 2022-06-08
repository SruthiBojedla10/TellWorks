package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Support_PO_SA_Reversals extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbSearch']")
	public WebElement supportPSR_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvPOReversalsList']")
	public WebElement supportPSR_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbReset']")
	public WebElement supportPSR_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement supportPSR_Reset_Message;
	
	@FindBy(xpath = "//input[@id = 'MainContent_btnExport']")
	public WebElement supportPSR_Export_Button;
	
	public Support_PO_SA_Reversals() {
		PageFactory.initElements(driver, this);
	}
}
