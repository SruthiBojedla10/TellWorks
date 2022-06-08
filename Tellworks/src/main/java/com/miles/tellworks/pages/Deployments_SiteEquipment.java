package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Deployments_SiteEquipment extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_PickFilter_lbSearch']")
	public WebElement sedh_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement sedh_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_PickFilter_lbReset']")
	public WebElement sedh_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement sedh_Reset_Message;

	@FindBy(xpath = "//input[@id = 'MainContent_PickFilter_lbExport']")
	public WebElement sedh_Export_Button;
	
	public Deployments_SiteEquipment() {
		PageFactory.initElements(driver, this);
	}
}
