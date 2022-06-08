package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Deployments_OrderedvsDeployed extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement dOvsD_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement dOvsD_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement dOvsD_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement dOvsD_Reset_Message;

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement dOvsD_Export_Button;
	
	public Deployments_OrderedvsDeployed() {
		PageFactory.initElements(driver, this);
	}
}
