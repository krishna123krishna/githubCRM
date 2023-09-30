package com.CRM.Vtiger.practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendarPopupFeatureDate {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		String month="December";
		String year="2023";
		while(true)
		{
		String monthyear=driver.findElement(By.className("DayPicker-Day DayPicker-Day--selected")).getText();
		String arr[]=monthyear.split(" ");
		String mon=arr[0];
	    String yer=arr[1];
	    
	    if(mon.equalsIgnoreCase(month) && yer.equals(year))
	    {
	    	break;
	    }
	    else {
	    	driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	    }
	    driver.findElement(By.cssSelector("[aria-label='Fri Dec 08 2023']")).click();
		}
	}

}
