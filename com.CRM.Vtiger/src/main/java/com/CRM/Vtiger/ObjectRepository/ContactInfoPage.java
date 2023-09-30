package com.CRM.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	@FindBy(css=".dvHeaderText")private WebElement contactHeader;
	
public ContactInfoPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
public String contactInfo()
{
	
	return contactHeader.getText();
	
}

}
