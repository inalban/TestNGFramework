package com.hubspot.Tests;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hubspot.Base.BasePage;

import com.hubspot.listeners.TestAllureListener;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.Constants;

@Listeners(TestAllureListener.class)
public class HomePageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title= homePage.getHomePageTitle();
		System.out.println("home page title is: "+ title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	
		
	}
	
	@Test(priority=2)
	public void verifyHomePageHeader(){
		String headerValue = homePage.getHomePageHeaderValue();
		System.out.println("home page header is: "+ headerValue);
		Assert.assertEquals(headerValue, Constants.HOME_PAGE_HEADER);
	}
	
	@Test(priority=3)
	public void verifyLoggedInUserAccountTest(){
		String accountName= homePage.getLoggedAccountName();
		System.out.println("logged in account name: "+ accountName);
		//Assert.assertTrue(homePage.verifyLoggedAccountName());
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
