package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Deployments_CAPXInventory extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbSearch']")
	public WebElement capx_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement capx_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbReset']")
	public WebElement capx_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement capx_Reset_Message;

	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbExport']")
	public WebElement capx_Export_Button;
	
	public Deployments_CAPXInventory() {
		PageFactory.initElements(driver, this);
	}
}
