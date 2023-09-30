package com.CRM.Vtiger.practice;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class fileupload {

	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("file:///C:/Users/MY%20PC/Desktop/fileupload.html");
		WebElement wb=driver.findElement(By.xpath("//input[@type='file']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", wb);
		File f=new File("./src/test/resources/Screenshot 2023-06-28 224633.jpg");
		String path=f.getAbsolutePath();
		wb.sendKeys(path);
		

	}

}
