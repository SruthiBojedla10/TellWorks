package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Receiving_ReceivingReversals extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbSearch']")
	public WebElement receivingReversals_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvPOReversalsList']")
	public WebElement receivingReversals_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbReset']")
	public WebElement receivingReversals_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement receivingReversals_Reset_Message;
	
	@FindBy(xpath = "//input[@id = 'MainContent_btnExport']")
	public WebElement receivingReversals_Export_Button;
	
	public Receiving_ReceivingReversals() {
		PageFactory.initElements(driver, this);
	}
}
