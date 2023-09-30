package com.CRM.Vtiger;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;

public class Read_data_from_csv {

	public static void main(String[] args) throws Throwable {
		try{//to read data from any file 
		FileReader fr=new FileReader("./src/test/resources/test_csv.csv");
		//to read data from csv file 
		CSVReader reader=new CSVReader(fr);
		String cell[];
		while((cell=reader.readNext())!=null) {
			
			String un=cell[0];
			String pwd=cell[1];
			System.out.println(un+"\n"+pwd);
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://localhost:8888");
			driver.findElement(By.name("user_name")).sendKeys(un);
			driver.findElement(By.name("user_password")).sendKeys(pwd);
			driver.findElement(By.id("submitButton")).click();
		}
	
		
      }
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
