package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Support_ConfirmedKitList extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbSearch']")
	public WebElement supportCKL_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvKitList']")
	public WebElement supportCKL_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbReset']")
	public WebElement supportCKL_Reset_Button;

	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement supportCKL_Reset_Message;
		
	public Support_ConfirmedKitList() {
		PageFactory.initElements(driver, this);
	}
}
