package com.qa.automation.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.auotmation.pages.LoginPage;
import com.qa.auotmation.pages.CommomPage;
import com.qa.auotmation.pages.RegistrationPage;
import com.qa.automation.utils.Utils;

public class RegistrationTest extends CommonTest {
	

	RegistrationPage registration;
	CommomPage memail ;
	
	
	@BeforeClass
	public void initialSetup() throws Exception {
		
		System.out.println("Start test :*******************************"
				+ "********************  RegistrationTest  *******************************"
				+ "***************************************************");	
		memail= setupEnvironment();
		memail.clickonElement(memail.registerLink, "memail registration link");
		Thread.sleep(3000);
		registration = new RegistrationPage(driver);	
		
	}
	
	
	@Test(priority=0)
	public void registerUser() throws Exception {
		System.out.println("Starting test :::::::::: registerUser ::::::::::");
		String userName = "AutomationTesting_"+Utils.getRandomIntNumber();		
		registration.setUserNameAndPassword(userName,propertyReader.getFieldValue("MemailRegistrationPassword"));
		registration.clickonContinue();
		Thread.sleep(3000);
		if(!registration.isExistsUsernameError()){
			memail.verifyElementText(memail.loggedInUser,"Logged_In_User","welcome, "+userName,false);
		} 
		else{
			System.out.println("Unable to register as username is not available");
		}	
		
		System.out.println("Ending test :::::::::: registerUser ::::::::::");
	}
}
