package com.miles.tellworks.pagepanel;

import com.miles.tellworks.mainmenu.TellworksBase;
import com.miles.tellworks.pages.HomePage;

public class HomePagePanel extends TellworksBase {

	HomePage homePage;
	
	public String HomePageTitleVerification() {
				homePage = new HomePage();
				homePage.homePage_Button.click();
				return driver.getTitle();
	}
}
