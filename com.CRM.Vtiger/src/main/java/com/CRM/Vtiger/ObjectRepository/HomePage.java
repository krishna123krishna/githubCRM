package com.CRM.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.Vtiger.GenericUtilities.WebDriverutility;

public class HomePage extends WebDriverutility{

	@FindBy(linkText="Organizations")private WebElement orgLinkEdt;
	
	@FindBy(linkText="Contacts")private WebElement contactLinkEdt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement singoutLink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void clickOrganization() {
		orgLinkEdt.click();
	}
	
	public void contact() {
		contactLinkEdt.click();
	}
	public void logoutFromApp(WebDriver driver) {
		moveToElement(driver, AdministratorImg);
		singoutLink.click();
	}

	
	
	
}
