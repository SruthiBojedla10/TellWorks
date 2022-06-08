package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Deployments_BOMSS extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_GridFilter_lbSearch']")
	public WebElement bomSS_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvBOMShortages']")
	public WebElement bomSS_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_GridFilter_lbReset']")
	public WebElement bomSS_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement bomSS_Reset_Message;

	@FindBy(xpath = "//input[@id = 'MainContent_GridFilter_lbExport']")
	public WebElement bomSS_Export_Button;
	
	public Deployments_BOMSS() {
		PageFactory.initElements(driver, this);
	}
}
