package com.qa.automation.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.auotmation.pages.LoginPage;
import com.qa.auotmation.pages.CommomPage;
import com.qa.automation.common.PropertyReader;


public class LoginTest extends CommonTest {
	
	LoginPage login ;
	CommomPage memail ;
		
	@BeforeClass
	public void initialSetup() throws Exception {
		
		System.out.println("Start test :*******************************"
				+ "********************  LoginTest  *******************************"
				+ "***************************************************");	
		memail= setupEnvironment();
		//do sign in before calling login page  
		memail.clickonElement(memail.signIn,"Memail Sign-in button");
		// wait for object
		Thread.sleep(5000);
		login = new LoginPage(driver);
		
	}
	
	
	@Test(priority=0)
	public void loginWithInvalidUser() throws Exception {
		System.out.println("Starting test :::::::::: loginWithInvalidUser ::::::::::");
		String username = propertyReader.getFieldValue("MemailUserName")+"123";
		String password = propertyReader.getFieldValue("MemailUserPassword");
		login.setUserNameAndPassword(username, password);
		login.clickonLogin();
		Thread.sleep(500);
		login.verifyErrorMessage("LOGIN FAILED. Check your login credentials and try again.");
		System.out.println("Ending test :::::::::: loginWithInvalidUser ::::::::::");
	}
	
	
	@Test(priority=1)
	public void loginWithInvalidPassword() throws Exception {
		System.out.println("Starting test :::::::::: loginWithInvalidPassword ::::::::::");
		String username = propertyReader.getFieldValue("MemailUserName");
		String password = propertyReader.getFieldValue("MemailUserPassword")+"123";
		login.setUserNameAndPassword(username, password);
		login.clickonLogin();
		Thread.sleep(500);
		login.verifyErrorMessage("LOGIN FAILED. Check your login credentials and try again.");		
		System.out.println("Ending test :::::::::: loginWithInvalidPassword ::::::::::");
	}
	
	
	@Test(priority=2)
	public void loginWithCorrectCredentials() throws Exception {
		System.out.println("Starting test :::::::::: loginWithCorrectCredentials ::::::::::");
		String username = propertyReader.getFieldValue("MemailUserName");
		String password = propertyReader.getFieldValue("MemailUserPassword");
		login.setUserNameAndPassword(username, password);
		login.clickonLogin();
		Thread.sleep(5000);
		memail.verifyElementText(memail.loggedInUser,"Logged_In_User","welcome, "+username,false);
		System.out.println("Ending test :::::::::: loginWithCorrectCredentials ::::::::::");	
	}
	
	
	@AfterClass
	public void endTest(){
		System.out.println("End test :*******************************"
				+ "********************  LoginTest  *******************************"
				+ "***************************************************");	
		driver.quit();
		
		
	}

}
