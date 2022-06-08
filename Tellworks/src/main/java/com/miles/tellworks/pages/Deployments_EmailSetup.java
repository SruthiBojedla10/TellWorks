package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Deployments_EmailSetup extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_txtSearch']")
	public WebElement eMail_Search_TextBox;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement eMail_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvEmailNotificationList_gv']")
	public WebElement eMail_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement eMail_Reset_Button;
	
	public Deployments_EmailSetup() {
		PageFactory.initElements(driver, this);
	}
}
