package com.CRM.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	@FindBy(name="lastname")private WebElement lastName;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveBtn;
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public String createcontact(String name) 
	{	
	lastName.sendKeys(name);
	saveBtn.click();
	return name;
	}


}
