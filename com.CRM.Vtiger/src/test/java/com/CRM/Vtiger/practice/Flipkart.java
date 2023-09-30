package com.CRM.Vtiger.practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Flipkart {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		
    	try
		{
			driver.findElement(By.xpath("//span[text()='✕']")).click();
			
		}
		catch(Exception e) 
    	{	
		}
    	driver.findElement(By.xpath("//button[contains(@class,'_2doB4z')]")).click();
		
		WebElement electronics= driver.findElement(By.xpath("//div[text()='Electronics']"));
		Actions act=new Actions(driver);
		act.moveToElement(electronics).perform();
		
		
		WebElement gaming=driver.findElement(By.xpath("//a[text()='Gaming']"));
		act.moveToElement(gaming).perform();
	
		
		
		WebElement game=driver.findElement(By.linkText("Gamepads"));
		act.moveToElement(game).click().perform();
		driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();
		
		WebElement title=driver.findElement(By.xpath("//a[contains(text(),'Gonsgadapp Pubg Controller')]"));
		String msg=title.getText();
		System.out.println(msg);
		title.click();
		
		String mainid=driver.getWindowHandle();
		Set<String>allid=driver.getWindowHandles();
		for(String id:allid)
		{
			if(!(mainid).equals(id))
			{
				driver.switchTo().window(id);
			}
		}
		driver.findElement(By.xpath("//label[text()='Compare']")).click();
		driver.findElement(By.xpath("//span[text()='COMPARE']")).click();
		String msg2=driver.findElement(By.xpath("//a[contains(text(),'Gonsgadapp Pubg Controller')]")).getText();
		System.out.println(msg2);
		
		if(msg.contains(msg2));
		{
			System.out.println("Tc pass");
		}	
		 {
			System.out.println("TC fail");
		}
	        driver.quit();
	}

}
