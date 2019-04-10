package com.qa.automation.tests;

import com.qa.automation.common.GlobalDriver;
import com.qa.automation.common.PropertyReader;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.qa.auotmation.pages.CommomPage;

public class CommonTest {
	
	CommomPage page ;
	GlobalDriver gDriver ;
	PropertyReader propertyReader ;
	protected WebDriver driver;
	
	public CommomPage setupEnvironment() throws InterruptedException, IOException{
		
		gDriver = new GlobalDriver();
		driver = gDriver.init();
		propertyReader = new PropertyReader("Configuration.properties");
				
		String username=propertyReader.getFieldValue("AzureLoginUserName");
		String password=propertyReader.getFieldValue("AzureUserPassword");
		String url =propertyReader.getFieldValue("URL");
		
		page = new CommomPage(driver);
		page.navigate(url);
		page.login(username ,password);
		
		return page ;
		
	}
	
	

}
