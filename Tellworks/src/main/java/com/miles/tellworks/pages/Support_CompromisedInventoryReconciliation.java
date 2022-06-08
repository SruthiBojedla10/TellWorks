package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Support_CompromisedInventoryReconciliation extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_btnSearch']")
	public WebElement supportCIR_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvCompromisedInventory']")
	public WebElement supportCIR_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_btnReset']")
	public WebElement supportCIR_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement supportCIR_Reset_Message;
	
	@FindBy(xpath = "//input[@id = 'MainContent_btnExport']")
	public WebElement supportCIR_Export_Button;
	
	public Support_CompromisedInventoryReconciliation() {
		PageFactory.initElements(driver, this);
	}
}
