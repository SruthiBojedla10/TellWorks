package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Deployments_BOM_Import extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_BOMHeader_lbSearch']")
	public WebElement deploymentsBOMimport_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement deploymentsBOMimport_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_BOMHeader_lbReset']")
	public WebElement deploymentsBOMimport_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_upBOMImport']")
	public WebElement deploymentsBOMimport_Reset_Message;
	
	public Deployments_BOM_Import() {
		PageFactory.initElements(driver, this);
	}
}
