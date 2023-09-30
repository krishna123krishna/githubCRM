package com.CRM.Vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.CRM.Vtiger.ObjectRepository.HomePage;
import com.CRM.Vtiger.ObjectRepository.loginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver Listnerdriver;
	public Fileutility futil=new Fileutility();
	public WebDriverutility wutil=new WebDriverutility();
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void beforesuiteconfig() {
		System.out.println("create the database connection");
	}
	@Parameters("browser")
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void beforeClassConfig(String Browser) throws Throwable {
		//String Browser = futil.getdataFromPropertyFile("browser");//when you writing from the suite.xml file
		String Browser=System.getProperty("browser");
		//String URL = futil.getdataFromPropertyFile("url");
		//runtime polymorpshiam or method overriding
		if(Browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox")) 
		{//remove else when you writing from the suite.xml file
			driver=new FirefoxDriver();
		}
		//else
			//driver=new EdgeDriver();
		System.out.println("Invalid Browser");
		//Listnerdriver=driver;;//Listners
		wutil.maximize(driver);
		wutil.wait(driver);
		driver.get(URL);
	}
		
		@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
		public void beforeMethodConfig() throws Throwable
		{
			String UN = futil.getdataFromPropertyFile("username");
			String PWD = futil.getdataFromPropertyFile("password");
			loginPage lp=new loginPage(driver);
			lp.logIntoApp(UN, PWD);
		}
		
		@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
		public void afterMethodConfig() throws Throwable
		{
			HomePage hp=new HomePage(driver);
			hp.logoutFromApp(driver);
		}
		@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
		public void afterclassConfig()
		{
			driver.quit();
		}
		@AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
		public void aftersuiteConfig()
		{
			System.out.println("colse the database connection");
		}
		
	}
