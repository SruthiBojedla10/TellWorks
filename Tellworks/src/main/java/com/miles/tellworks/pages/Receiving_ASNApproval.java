package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Receiving_ASNApproval extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbSearch']")
	public WebElement asna_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvSAASNList']")
	public WebElement asna_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbReset']")
	public WebElement asna_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement asna_Reset_Message;
	
	public Receiving_ASNApproval() {
		PageFactory.initElements(driver, this);
	}
}
