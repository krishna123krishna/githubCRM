package com.CRM.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {
	@FindBy(name="accountname")private WebElement orgName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveBtn;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void createName(String orgname) {
		orgName.sendKeys(orgname);
		saveBtn.click();
	}

}
