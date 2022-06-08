package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Maintenance_WareHouse_Location extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_txtSearch']")
	public WebElement warehouse_Search_TextBox;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbSearch']")
	public WebElement warehouse_Go_Button;

	@FindBy(xpath = "//table[@id = 'MainContent_tabContainerMain_tabWarehouse_gvWarehouse']")
	public WebElement warehouse_Table;
	
	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbReset']")
	public WebElement warehouse_Reset_Button;
	
	@FindBy(xpath = "//div[@id = 'MainContent_tabContainerMain_tabWarehouse_divEnterQueryMessageWarehouse']")
	public WebElement warehouse_Reset_Message;
	
	@FindBy(xpath = "//span[@id = 'MainContent_tabContainerMain_tabStorage_tab']")
	public WebElement warehouse_Locatios_Button;
	
	@FindBy(xpath = "//span[@id = 'MainContent_tabContainerMain_tabZone_tab']")
	public WebElement warehouse_Zones_Button;

	@FindBy(xpath = "//input[@id = 'MainContent_GridHeader_lbExport']")
	public WebElement warehouse_Export_Button;

	public Maintenance_WareHouse_Location() {
		PageFactory.initElements(driver, this);
	}
}
