package com.miles.tellworks.mainmenu;

import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TellworksBase {

	public static WebDriver driver;

	public void driverInitialization() {

		String path = System.getProperty("user.dir");   
		String driverpath = path + "\\ChromeDriver\\chromedriver.exe";   
		System.setProperty("webdriver.chrome.driver",driverpath );
		driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(2000,0));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://projectaimstwo.tellworks.com/Account/login.aspx");
	}
}
