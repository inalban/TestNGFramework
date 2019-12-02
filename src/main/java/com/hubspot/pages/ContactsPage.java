package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;

public class ContactsPage {
	
	/**
	 * @author 
	 */
	WebDriver driver;
	ElementUtil elementUtil;

	By createContactButton = By.xpath("//span[contains(text(),'Create contact')]");
	//By createContactButton = By.xpath("//div[@class='app LayoutFullPage']//div[4]//div[1]");
	By createContactFormButton = By.xpath("//div[@class='private-layer']//li[1]");
	By email = By.xpath("//input[@name='textInput']");
	By firstName = By.xpath("//input[@class='form-control private-form__control' and @data-field='firstname']");
	By lastName = By.xpath("//input[@class='form-control private-form__control' and @data-field='lastname']");
	By jobTitle = By.xpath("//input[@class='form-control private-form__control' and @data-field='jobtitle']");
	
	
//	By createContactButton = By.xpath("//span[text()='Create contact']");
//	By createContactFormButton = By.xpath("//li//span[text()='Create contact']");
//	By email = By.id("uid-ctrl-1");
//	By firstName = By.id("uid-ctrl-2");
//	By lastName = By.id("uid-ctrl-3");
//	By jobTitle = By.id("uid-ctrl-5");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getContactsPageTitle() {
		return elementUtil.waitForGetPageTitle(Constants.CONTACTS_PAGE_TITLE);
	}

	public void createNewContact(String emailID, String FN, String LN, String jobTitleVal) {
		elementUtil.doClick(createContactButton);
		elementUtil.doSendKeys(email, emailID);
		elementUtil.doSendKeys(firstName, FN);
		elementUtil.doSendKeys(lastName, LN);
		elementUtil.doSendKeys(jobTitle, jobTitleVal);

		elementUtil.doClick(createContactFormButton);
	}
	
	
	

}
