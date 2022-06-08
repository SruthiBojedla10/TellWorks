package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Deployments_BOMManagement extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement bomM_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement bomM_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement bomM_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement bomM_Reset_Message;

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement bomM_Export_Button;	
	
	public Deployments_BOMManagement() {
		PageFactory.initElements(driver, this);
	}
}
