package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Deployments_Warehouse extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement wareHouse_Reset_Button;

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement wareHouse_Export_Button;
	
	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement wareHouse_Table;
	
	@FindBy(xpath = "//div[@id = 'MainContent_upGrid']")
	public WebElement wareHouse_Reset_Message;
	
	public Deployments_Warehouse() {
		PageFactory.initElements(driver, this);
	}
}
