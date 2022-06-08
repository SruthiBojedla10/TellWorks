package com.miles.tellworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.miles.tellworks.mainmenu.TellworksBase;

public class LoginPage extends TellworksBase {

	@FindBy(xpath = "//input[@id = 'MainContent_UserName']")
	public WebElement login_UserName;

	@FindBy(xpath = "//input[@id = 'MainContent_Password']")
	public WebElement login_Password;

	@FindBy(xpath = "//input[@id = 'MainContent_btnLogin']")
	public WebElement login_Button;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

}
