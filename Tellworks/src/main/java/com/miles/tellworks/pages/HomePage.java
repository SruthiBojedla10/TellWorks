package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.miles.tellworks.mainmenu.TellworksBase;

public class HomePage extends TellworksBase {
	
	@FindBy(xpath = "//a[@class = 'navbar-brand']")
	public WebElement homePage_Button;

	@FindBy(xpath = "//a[@id = 'Administration']")
	public WebElement admin_Dropdown;

	@FindBy(xpath = "//a[@id = 'Inventory']")
	public WebElement inventory_Dropdown;

	@FindBy(xpath = "//a[@id = 'RMA']")
	public WebElement operations_Dropdown;

	@FindBy(xpath = "//a[@id = 'Dashboard']")
	public WebElement dashboard_Dropdown;

	@FindBy(xpath = "//a[@id = 'A2']")
	public WebElement deployements_Dropdown;

	@FindBy(xpath = "//a[@id = 'A1']")
	public WebElement support_Dropdown;

	@FindBy(xpath = "//li[@id = 'liReceiving']")
	public WebElement receiving_Dropdown;
	
	@FindBy(xpath = "//li[@id = 'liMaintenance']")
	public WebElement maintenance_Dropdown;
	
	@FindBy(xpath = "//li[@id = 'liReturnManagement']")
	public WebElement returns_Dropdown;
	
	@FindBy(xpath = "//a[@id = 'liDigitalLayer']")
	public WebElement digitalLayer_Dropdown;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
}
