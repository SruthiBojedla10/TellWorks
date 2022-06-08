package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Inventory_OnHandSummary extends TellworksBase{

	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbSearch']")
	public WebElement onHandSummary_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement onHandSummary_Table;

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_txtSearch']")
	public WebElement onHandSummary_Search_TextBox;	
	
	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbReset']")
	public WebElement onHandSummary_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement onHandSummary_Reset_Message;
	
	@FindBy(xpath = "//input[@id = 'MainContent_UserFilter_lbExport']")
	public WebElement onHandSummary_Export_Button;
	
	public Inventory_OnHandSummary() {
		PageFactory.initElements(driver, this);
	}
}
