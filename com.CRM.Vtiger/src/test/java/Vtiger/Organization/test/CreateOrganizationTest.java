package Vtiger.Organization.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.CRM.Vtiger.GenericUtilities.ExcelFileutility;
import com.CRM.Vtiger.GenericUtilities.Fileutility;
import com.CRM.Vtiger.GenericUtilities.Javautilty;
import com.CRM.Vtiger.ObjectRepository.CreateNewOrganizationPage;
import com.CRM.Vtiger.ObjectRepository.HomePage;
import com.CRM.Vtiger.ObjectRepository.OrganizationInfoPage;
import com.CRM.Vtiger.ObjectRepository.OrganizationPage;
import com.CRM.Vtiger.ObjectRepository.loginPage;

public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		Fileutility file =new Fileutility();
		Javautilty jutil=new Javautilty();
		String un=file.getdataFromPropertyFile("username");
		String pwd=file.getdataFromPropertyFile("password");
		String url=file.getdataFromPropertyFile("url");
	
		//runtime polymorphism or method overriding
		String browser=file.getdataFromPropertyFile("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}else
			System.out.println("invalid browser");
		
		//random; 
				ExcelFileutility eutil=new ExcelFileutility();
				String orgname=eutil.getDataformExcelSheet("TestData", 0, 1)+jutil.getrandom();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		/*driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();*/
		loginPage lp=new loginPage(driver);
		lp.logIntoApp(un,pwd);
		
		HomePage hp=new HomePage(driver);
		hp.clickOrganization();
		//driver.findElement(By.linkText("Organizations")).click();
		
		OrganizationPage org=new OrganizationPage(driver);
		org.clickOrgLookUpImg();
		
		//driver.findElement(By.xpath("//img[contains(@title,'Crea')]")).click();
		
//		driver.findElement(By.name("accountname")).sendKeys(orgname);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreateNewOrganizationPage corg=new CreateNewOrganizationPage(driver);
		corg.createName(orgname);
		OrganizationInfoPage or=new OrganizationInfoPage(driver);
		String orgHeader=or.orgHader();
		/*String orgHeader=driver.findElement(By.cssSelector(".dvHeaderText")).getText();*/
		if(orgHeader.contains(orgname)) {
			System.out.println("pass");
		}
		else
			System.out.println("fail");
		/*WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
		hp.logoutFromApp(driver);
		driver.close();
		
	}

}
