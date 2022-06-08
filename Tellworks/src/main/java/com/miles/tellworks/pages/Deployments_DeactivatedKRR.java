package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Deployments_DeactivatedKRR extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_lbSearch']")
	public WebElement dkrr_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvKitList']")
	public WebElement dkrr_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_lbReset']")
	public WebElement dkrr_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement dkrr_Reset_Message;

	@FindBy(xpath = "//input[@id = 'MainContent_btnExport']")
	public WebElement dkrr_Export_Button;
	
	public Deployments_DeactivatedKRR() {
		PageFactory.initElements(driver, this);
	}
}
