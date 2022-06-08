package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Support_InventoryMoves extends TellworksBase {
	
	@FindBy(xpath = "//input[@name = 'SAP']")
	public WebElement supportIM_SAP;

	@FindBy(xpath = "//input[@name = 'FromLPN']")
	public WebElement supportIM_From_LPN;
	
	@FindBy(xpath = "//input[@name = 'StorageName']")
	public WebElement supportIM_StorageLocation;
	
	@FindBy(xpath = "//input[@name = 'QuantityEntered']")
	public WebElement supportIM_Move_Quantity;
	
	@FindBy(xpath = "//input[@name = 'DestinationStorageName']")
	public WebElement supportIM_destination_StorageLocation;
	
	@FindBy(xpath = "//input[@name = 'ToLPN']")
	public WebElement supportIM_To_LPN;
	
	@FindBy(xpath = "//*[@id=\"tbl-inventory\"]/tbody/tr/td[9]/span/a")
	public WebElement supportIM_firstValidatebutton;
	
	@FindBy(xpath = "//*[@id=\"tbl-inventory\"]/tbody/tr/td[21]/span/a")
	public WebElement supportIM_secondValidatebutton;
	
	@FindBy(xpath = "//button[@id='ConfirmItems']")
	public WebElement supportIM_Confirm_Button;
		
	public Support_InventoryMoves() {
		PageFactory.initElements(driver, this);
	}
}
