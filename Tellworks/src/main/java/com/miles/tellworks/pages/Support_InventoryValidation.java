package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Support_InventoryValidation extends TellworksBase {

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement supportIV_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbExportBD']")
	public WebElement supportIV_ExportBaseline_Button;
	
	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbExportVD']")
	public WebElement supportIV_ExportValidation_Button;
	
	public Support_InventoryValidation() {
		PageFactory.initElements(driver, this);
	}
}
