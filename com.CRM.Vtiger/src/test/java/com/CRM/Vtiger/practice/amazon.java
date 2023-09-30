package com.CRM.Vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazon {
	public static void main(String[]args) throws EncryptedDocumentException, IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		
		List<WebElement> all=driver.findElements(By.xpath("//a"));
			FileInputStream fc=new FileInputStream("C:\\selenium\\actitimename.xlsx");
			Workbook book=WorkbookFactory.create(fc);
			Sheet sh=book.getSheet("Sheet2");
			int row =0;
			for(WebElement onelink:all)
			{
			sh.createRow(row).createCell(0).setCellValue(onelink.getAttribute("href"));	
			row++;
			}
			FileOutputStream fos=new FileOutputStream("C:\\selenium\\actitimename.xlsx");
			book.write(fos);
		//hello
		}	
	}


