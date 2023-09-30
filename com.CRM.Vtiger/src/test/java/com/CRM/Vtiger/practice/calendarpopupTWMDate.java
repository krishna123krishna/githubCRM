package com.CRM.Vtiger.practice;

import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendarpopupTWMDate {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.cssSelector("[class='commonModal__close']")).click();
		driver.findElement(By.cssSelector("[for='departure']")).click();
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR,1);
		Date tmrwdate=cal.getTime();
		System.out.println(tmrwdate);
		driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--selected']")).click();
	}

}
