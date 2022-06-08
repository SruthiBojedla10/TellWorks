package com.miles.tellworks.pagepanel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.miles.tellworks.excelutil.Xls_Reader;
import com.miles.tellworks.mainmenu.TellworksBase;
import com.miles.tellworks.pages.DigitalLayer_Corrections;
import com.miles.tellworks.pages.HomePage;

public class DigitalLayer extends TellworksBase{

	HomePage homePage;
	CommonMethods commonMethods;
	DigitalLayer_Corrections digitalLayerCorrections;
	
	Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "\\TestData\\Tellworks_Data.xlsx");
	
	public boolean DigitalLayerCorrections() throws InterruptedException {

		homePage = new HomePage();
		commonMethods = new CommonMethods();
		digitalLayerCorrections = new DigitalLayer_Corrections();
		String Source_Search = reader.getCellData("Receiving_Data", "DigitalSource_Search", 2);
		homePage.digitalLayer_Dropdown.click();
		commonMethods.clicklink("Digital Layer Corrections");
		Select select = new Select(driver.findElement(By.xpath("//select[@id = 'MainContent_ddlErrorSource']")));
		select.selectByVisibleText(Source_Search);
		digitalLayerCorrections.digitalLC_Go_Button.click();
		Thread.sleep(3000);
		int noofRows = driver.findElements(By.xpath("//table[@id = 'MainContent_gvDigitalLayerFailedTransactions']/tbody/tr")).size();
		for(int i=1;i<=noofRows-2;i++) {
			String verifyProject = driver.findElement(By.xpath("//table[@id = 'MainContent_gvDigitalLayerFailedTransactions']/tbody/tr["+(i+1)+"]/td[3]")).getText();
			if(!verifyProject.equals(Source_Search)) {
				return false;
			}
		}
		Thread.sleep(3000);
		digitalLayerCorrections.digitalLC_Reset_Button.click();
		if(!digitalLayerCorrections.digitalLC_Reset_Message.getText().equals("Enter search criteria and select filter options, then press GO to display results.")) {
			return false;
		}
		return true;
	}
}
