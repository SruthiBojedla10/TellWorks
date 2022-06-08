package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Support_PODataSync extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_txtSearch']")
	public WebElement supportPDS_Search_TextBox;
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbSearch']")
	public WebElement supportPDS_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvErrors']")
	public WebElement supportPDS_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbReset']")
	public WebElement supportPDS_Reset_Button;

	public Support_PODataSync() {
		PageFactory.initElements(driver, this);
	}
}
