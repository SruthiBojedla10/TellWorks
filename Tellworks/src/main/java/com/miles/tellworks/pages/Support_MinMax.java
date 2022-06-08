package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Support_MinMax extends TellworksBase {
	
	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement supportMM_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_lbExport']")
	public WebElement supportMM_Export_Button;
	
	public Support_MinMax() {
		PageFactory.initElements(driver, this);
	}
}
