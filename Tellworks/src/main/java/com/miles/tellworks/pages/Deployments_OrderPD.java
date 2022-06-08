package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Deployments_OrderPD extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement dOPD_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement dOPD_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement dOPD_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_upGrid']")
	public WebElement dOPD_Reset_Message;

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement dOPD_Export_Button;
	
	public Deployments_OrderPD() {
		PageFactory.initElements(driver, this);
	}
}
