package com.CRM.Vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class FLipkartPriceCsvFile {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[contains(@class,'_2doB4z')]")).click();
		
		WebElement electronics= driver.findElement(By.xpath("//div[text()='Electronics']"));
		Actions act=new Actions(driver);
		act.moveToElement(electronics).perform();
		
		WebElement gaming=driver.findElement(By.xpath("//a[text()='Gaming']"));
		act.moveToElement(gaming).click().perform();
		
		driver.findElement(By.xpath("//a[text()='AMKETTE Evo Gamepad Pro 4 Controller with Instant Play ...']")).click();
		
		String mainid=driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		
		for(String id:allid)
		{
			if(!(mainid.equals(id)))
			{
				driver.switchTo().window(id);
			}
		}
		
		WebElement price = driver.findElement(By.cssSelector("[class='_30jeq3 _16Jk6d']"));
		String value=price.getText();
		FileInputStream fis=new FileInputStream("./src/test/resources/flipkart.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Sheet1");
		sh.createRow(0).createCell(0).setCellValue(value);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/flipkart.xlsx");
		book.write(fos);
	}

}



	

