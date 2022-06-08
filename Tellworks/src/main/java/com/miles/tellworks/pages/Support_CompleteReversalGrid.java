package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Support_CompleteReversalGrid extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_gvCompleteReversalGrid_txtSearch']")
	public WebElement supportCRG_Search_TextBox;
	
	@FindBy(xpath = "//input[@id = 'MainContent_gvCompleteReversalGrid_lbSearch']")
	public WebElement supportCRG_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gvCompleteReversalGrid_gvCompleteReversalGrid']")
	public WebElement supportCRG_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_gvCompleteReversalGrid_lbReset']")
	public WebElement supportCRG_Reset_Button;

	@FindBy(xpath = "//div[@id = 'MainContent_gvCompleteReversalGrid_divEnterQueryMessage']")
	public WebElement supportCRG_Reset_Message;
	
	@FindBy(xpath = "//input[@id = 'MainContent_gvCompleteReversalGrid_btnExport']")
	public WebElement supportCRG_Export_Button;
	
	public Support_CompleteReversalGrid() {
		PageFactory.initElements(driver, this);
	}
}
