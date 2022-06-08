package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Admin_SerialManagement extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_txtSearch']")
	public WebElement serialManagement_Search_TextBox;
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbSearch']")
	public WebElement serialManagement_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvSerialList']")
	public WebElement serialManagement_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbReset']")
	public WebElement serialManagement_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement serialManagement_Reset_Message;
	
	public Admin_SerialManagement() {
		PageFactory.initElements(driver, this);
	}
}
