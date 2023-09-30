package com.CRM.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(className="dvHeaderText")private WebElement orginfoEdt;
	
	public OrganizationInfoPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	public String orgHader() {
		return orginfoEdt.getText();
		
	}

}
