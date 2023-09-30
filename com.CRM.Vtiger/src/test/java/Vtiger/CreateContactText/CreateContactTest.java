package Vtiger.CreateContactText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.CRM.Vtiger.GenericUtilities.ExcelFileutility;
import com.CRM.Vtiger.GenericUtilities.Fileutility;
import com.CRM.Vtiger.GenericUtilities.Javautilty;
import com.CRM.Vtiger.GenericUtilities.WebDriverutility;
import com.CRM.Vtiger.ObjectRepository.ContactInfoPage;
import com.CRM.Vtiger.ObjectRepository.Contactspage;
import com.CRM.Vtiger.ObjectRepository.CreateNewContactPage;
import com.CRM.Vtiger.ObjectRepository.HomePage;
import com.CRM.Vtiger.ObjectRepository.OrganizationInfoPage;
import com.CRM.Vtiger.ObjectRepository.loginPage;

public class CreateContactTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		WebDriverutility wutil=new WebDriverutility();
		
		Fileutility file =new Fileutility();
		Javautilty jutil=new Javautilty();
		String un=file.getdataFromPropertyFile("username");
		String pwd=file.getdataFromPropertyFile("password");
		String url=file.getdataFromPropertyFile("url");
		 
		//random; 
		ExcelFileutility eutil=new ExcelFileutility();
		String name=eutil.getDataformExcelSheet("TestData", 0, 0)+jutil.getrandom();
		
		//runtime polymorphism or method overriding
		String browser=file.getdataFromPropertyFile("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
			System.out.println("invalid browser");
		
		wutil.maximize(driver);
		wutil.wait(driver);
		driver.get(url);
		/*driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();*/
		
		loginPage lp=new loginPage(driver);
		lp.logIntoApp(un,pwd);
		
		driver.findElement(By.linkText("Organizations")).click();
		HomePage hp=new HomePage(driver);
		hp.contact();
		//driver.findElement(By.linkText("Contacts")).click();
		
		
		Contactspage cn=new Contactspage(driver);
		cn.contactLookUpImg();
		/*driver.findElement(By.xpath("//img[contains(@title,'Crea')]")).click();
		 */
		CreateNewContactPage cont=new CreateNewContactPage(driver);
		cont.createcontact(name);
		//driver.findElement(By.name("lastname")).sendKeys(name);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		wutil.screenShot(driver, name);
		ContactInfoPage cip=new ContactInfoPage(driver);
		String orgHeader=cip.contactInfo();
		//String orgHeader=driver.findElement(By.cssSelector(".dvHeaderText")).getText();
		if(orgHeader.contains(name)) 
		{
			System.out.println("pass");
		}
		else
			System.out.println("fail");
		
		
		/*WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutil.screenShot(ele, "ele");
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
		hp.logoutFromApp(driver);
		driver.close();

	}

}
