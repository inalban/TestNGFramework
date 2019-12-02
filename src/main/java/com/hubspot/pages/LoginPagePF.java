package com.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.hubspot.Base.BasePage;
import com.hubspot.util.ElementUtilPF;

public class LoginPagePF extends BasePage{
	
	WebDriver driver;
	ElementUtilPF elementUtilPF;
	
	//Page Factory pattern: with help of @FindBy
	@FindBy(id="username")
	WebElement emailId;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginButton;
	
	public LoginPagePF(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtilPF = new ElementUtilPF(driver);
	}
	
	public void doLogin(String username, String pwd){
		elementUtilPF.waitForElementPresent(emailId);
		emailId.sendKeys(username);
		password.sendKeys(pwd);
		loginButton.click();
	}

}
