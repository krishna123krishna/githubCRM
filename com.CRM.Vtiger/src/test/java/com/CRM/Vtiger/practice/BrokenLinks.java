package com.CRM.Vtiger.practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		List<WebElement> alllinks=driver.findElements(By.xpath("//a"));
		ArrayList<String> BrokenLinks=new ArrayList<String>();
		for(int i=0;i<alllinks.size();i++)
		{
			String links=alllinks.get(i).getAttribute("href");
			int statuscode =0;
			try 
			{
				URL url=new URL(links);
				URLConnection urlconn=url.openConnection();
				HttpURLConnection httpulconn=(HttpURLConnection)urlconn;
				statuscode=httpulconn.getResponseCode();
				if(statuscode>=400)
				{
					BrokenLinks.add(links+" "+statuscode);
				}
			}
			catch(Exception e) {
				continue;
			}
			
	      }
		System.out.println(BrokenLinks);
		}
	}
