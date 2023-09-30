package com.CRM.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	@FindBy(name="user_name")private WebElement usernameEdt;
	
	@FindBy(name="user_password")private WebElement passwordEdt;
	
	@FindBy(id="submitButton")private WebElement logInBtn;
	
	//Intialise Element
	public loginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	public void logIntoApp(String username,String password) {
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		logInBtn.click();
		
	}

}
