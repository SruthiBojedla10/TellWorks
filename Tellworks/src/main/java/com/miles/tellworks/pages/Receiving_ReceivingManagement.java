package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Receiving_ReceivingManagement extends TellworksBase {
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement receivingManagement_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_gv_gv']")
	public WebElement receivingManagement_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement receivingManagement_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_divEnterQueryMessage']")
	public WebElement receivingManagement_Reset_Message;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement receivingManagement_Export_Button;
	
	public Receiving_ReceivingManagement() {
		PageFactory.initElements(driver, this);
	}
}
