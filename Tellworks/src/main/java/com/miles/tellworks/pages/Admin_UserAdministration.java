package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.miles.tellworks.mainmenu.TellworksBase;

public class Admin_UserAdministration extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_txtSearch']")
	public WebElement users_Search_TextBox;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement users_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvUsers']")
	public WebElement users_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement users_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement users_Reset_Message;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement users_Export_Button;
	
	public Admin_UserAdministration() {
		PageFactory.initElements(driver, this);
	}
}
