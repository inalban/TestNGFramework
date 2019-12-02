package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.Base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;

import sun.security.x509.AuthorityInfoAccessExtension;

/**
 * 
 * @author 
 *
 */

public class HomePage extends BasePage{
	
	
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By header = By.cssSelector("h1.private-header__heading>i18n-string");
	By accountName = By.cssSelector("a#account-menu>span.account-name ");
	
	By contactsMainTab =By.id("nav-primary-contacts-branch");
	By contactsChildTab = By.id("nav-secondary-contacts");

	public HomePage(WebDriver driver){
		this.driver =driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getHomePageTitle(){
		return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
		
	}
	
	public String getHomePageHeaderValue(){
		return elementUtil.doGetText(header);
	}
	
	public boolean verifyLoogedAccountName(){
		return elementUtil.isElementDisplayed(accountName);
	}
	
	public String getLoggedAccountName(){
		return elementUtil.doGetText(accountName);
	}
	
	private void clickOnContacts(){
		elementUtil.doClick(contactsMainTab);
		elementUtil.doClick(contactsChildTab);
	}
	
	public ContactsPage gotoContactsPage(){
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	
}
