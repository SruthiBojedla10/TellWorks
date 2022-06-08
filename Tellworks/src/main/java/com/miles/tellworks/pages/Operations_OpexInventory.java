package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Operations_OpexInventory extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbSearch']")
	public WebElement opex_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement opex_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_txtSearch']")
	public WebElement opexSearch_TextBox;
	
	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbReset']")
	public WebElement opex_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement opex_Reset_Message;

	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbExport']")
	public WebElement opex_Export_Button;
	
	public Operations_OpexInventory() {
		PageFactory.initElements(driver, this);
	}
}
