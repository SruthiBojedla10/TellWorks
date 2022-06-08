package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Deployments_ProjectSiteManagement extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement psm_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv_gv']")
	public WebElement psm_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement psm_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement psm_Reset_Message;

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement psm_Export_Button;
	
	public Deployments_ProjectSiteManagement() {
		PageFactory.initElements(driver, this);
	}
}
