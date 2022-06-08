package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.miles.tellworks.mainmenu.TellworksBase;

public class Admin_ReasonCodes extends TellworksBase {

	@FindBy(xpath = "//select[@id = 'MainContent_ddlLookupGroupChoice']")
	public WebElement reasonCodes_DropDown;
	
	@FindBy(xpath = "//table[@id = 'ctl00_MainContent_grdLookupCodes_ctl00']")
	public WebElement reasonCodes_Table;

	public Admin_ReasonCodes() {
		PageFactory.initElements(driver, this);
	}
}
