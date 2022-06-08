package com.miles.tellworks.pagepanel;

import com.miles.tellworks.excelutil.Xls_Reader;
import com.miles.tellworks.mainmenu.TellworksBase;
import com.miles.tellworks.pages.LoginPage;

public class TellWorksLogin extends TellworksBase {

	Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "\\TestData\\Tellworks_Data.xlsx");
	
	public void login() 
	{
		String username = reader.getCellData("Login_Page", "username", 2); 
		String password = reader.getCellData("Login_Page", "password", 2);
		 
		LoginPage ltw = new LoginPage();
		ltw.login_UserName.sendKeys(username);
		ltw.login_Password.sendKeys(password);
		ltw.login_Button.click();
	}

}
