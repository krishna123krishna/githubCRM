package com.CRM.Vtiger.practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendarpopupAnydateinDom {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("[class='commonModal__close']")).click();
		driver.findElement(By.cssSelector("[for='departure']")).click();
		driver.findElement(By.cssSelector("[aria-label='Wed Oct 04 2023']")).click();
		//driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--selected']")).click();
	}

}
