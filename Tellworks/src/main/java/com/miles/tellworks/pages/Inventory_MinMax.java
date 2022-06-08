package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.miles.tellworks.mainmenu.TellworksBase;

public class Inventory_MinMax extends TellworksBase{

	@FindBy(xpath = "//table[@id = 'MainContent_gv']")
	public WebElement inventory_MinMax__Table;

	public Inventory_MinMax() {
		PageFactory.initElements(driver, this);
	}
}
