package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Support_InventoryAdjustments extends TellworksBase {
	
	@FindBy(xpath = "//input[@name = 'SAP']")
	public WebElement supportIA_SAP;
	
	@FindBy(xpath = "//input[@name = 'StorageName']")
	public WebElement supportIA_StorageLocation;
	
	@FindBy(xpath = "//input[@name = 'ChangedQuantity']")
	public WebElement supportIA_AdjustQuantity;
	
	@FindBy(xpath = "//input[@name = 'Approver']")
	public WebElement supportIA_Approver;
	
	@FindBy(xpath = "//input[@name = 'CycleCountDate']")
	public WebElement supportIA_CountDate;
	
	@FindBy(xpath = "//*[@id=\"tbl-inventory\"]/tbody/tr/td[15]/span/a")
	public WebElement supportIA_Validatebutton;

	@FindBy(xpath = "//button[@id='ConfirmItems']")
	public WebElement supportIA_Confirm_Button;
		
	public Support_InventoryAdjustments() {
		PageFactory.initElements(driver, this);
	}
}
