package com.qa.auotmation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommomPage {
	
	@FindBy(xpath="//*[@id='Username']")
	private WebElement username ;
	
	@FindBy(xpath="//*[@id='Password']")
	private WebElement password ;
	
	@FindBy(xpath="//*[@id='login_form']/button")
	private WebElement meMailloginButton ;
	
	@FindBy(xpath="//*[@id='login_form']/div[@role='alert']/p")
	private WebElement errorMessage ;
	
	public void setUserNameAndPassword(String username,String password){
		enterText(this.username,"Username",username);
		enterText(this.password,"Password",password);
	}
	
	public void clickonLogin(){
		clickonElement(meMailloginButton,"memail_loginButton");
	}
	
	public void verifyErrorMessage(String expectedMessage){
		verifyElementText(errorMessage,"Error messaage",expectedMessage,true);
	}
	
	
	
		
	
	public LoginPage(WebDriver driver){
		//PageFactory.initElements(driver,this.getClass());
		super(driver);
	}

}
