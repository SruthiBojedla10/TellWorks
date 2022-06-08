package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Deployments_BOMMaintenance extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_BOMHeader_lbSearch']")
	public WebElement bom_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvBOMList']")
	public WebElement bom_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_BOMHeader_lbReset']")
	public WebElement bom_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement bom_Reset_Message;
	
	public Deployments_BOMMaintenance() {
		PageFactory.initElements(driver, this);
	}
}
