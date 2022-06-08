package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Admin_AdjustmentCodes extends TellworksBase {
	
	@FindBy(xpath = "//table[@id = 'ctl00_MainContent_grdReasonCodes_ctl00']")
	public WebElement adjustmentReasonCodes_Table;

	public Admin_AdjustmentCodes() {
		PageFactory.initElements(driver, this);
	}
}
