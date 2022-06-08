package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.miles.tellworks.mainmenu.TellworksBase;

public class Admin_UserAuditLog extends TellworksBase{

	@FindBy(xpath = "//input[@id = 'MainContent_lbSearch']")
	public WebElement usersAudit_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvUserAuditLogs_gv']")
	public WebElement usersAudit_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_txtUserName']")
	public WebElement usersAudit_Search_TextBox;
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbReset']")
	public WebElement usersAudit_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement usersAudit_Reset_Message;
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbExport']")
	public WebElement usersAudit_Export_Button;
	
	public Admin_UserAuditLog() {
		PageFactory.initElements(driver, this);
	}
}
