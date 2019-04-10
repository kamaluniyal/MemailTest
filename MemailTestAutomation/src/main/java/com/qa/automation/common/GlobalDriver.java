package com.qa.automation.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GlobalDriver {
	
	WebDriver driver ;
	
	public WebDriver init(){
		
		//System.setProperty("WebDriver.chrome.driver",this.getClass().getClassLoader().getResource("chromedriver").getFile());
		//driver = new ChromeDriver();
		System.out.println("Initializing browser session");
		//System.setProperty("webdriver.chrome.driver","C:\\Projects\\Java Selenium\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",this.getClass().getClassLoader().getResource("chromedriver.exe").getFile());
		driver = new ChromeDriver();
		return driver;
	}

}
