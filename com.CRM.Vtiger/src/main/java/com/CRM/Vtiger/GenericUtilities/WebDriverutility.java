package com.CRM.Vtiger.GenericUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverutility {
	WebDriver driver=null;
	/**
	 * this method maximize the window
	 * @param driver
	 */
	
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * this method minimize the window
	 * @param driver
	 */
	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * this method wait the weddriver for some time until the condition met
	 * @param driver
	 */
	public void wait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Ipath.explicitwaitDuration));
	}
	public void visibilty(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Ipath.explicitwaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void elementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Ipath.explicitwaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void alertIsPresent(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Ipath.explicitwaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * to handle the dropdown in generic code 
	 * @param element
	 * @param indexNo
	 */
	
	public void handleDropDown(WebElement element,int indexNo) {
		Select s=new Select(element);
		s.selectByIndex(indexNo);
	}
	public void handleDropDown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void handleDropDown(String value,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(value);
	} 
	/**
	 * how to handle the Alert popup methods in generic code
	 * @param driver
	 */
	public void acceptalert(WebDriver driver) {
		driver.switchTo().alert().accept();
		
	}
	public void dismissalert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public String getTextFromAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	/**
	 * By using this method we handle the fraame element using indexNo
	 * @param driver
	 * @param indexNo
	 */
	public void frameByindex(WebDriver driver,int indexNo)
	{
		driver.switchTo().frame(indexNo);
	}
	/**
	 *  By using this method we handle the fraame element using nameOrid
	 * @param driver
	 * @param nameid
	 */
	public void frameBynameid(WebDriver driver,String nameid)
	{
		driver.switchTo().frame(nameid);
	}
	/**
	 * By using this method we handle the fraame element using Webelement
	 * @param driver
	 * @param element
	 */
	public void frameByelemet(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void parentframe(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	public void defaultframe(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * by using this method we handle the mouse action
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	 
	public void rightclick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void rightclickAnyWhere(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	public void doubleclick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void doubleclickAnyWhere(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	public void dragAndDrop(WebDriver driver,WebElement srcelement,WebElement deselement)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcelement,deselement).perform();
	}
	public void dragAndDropBy(WebDriver driver,WebElement deselement)
	{
		Actions act=new Actions(driver);
		act.dragAndDropBy(deselement, 0, 0).perform();//if we want slide the element by same amt,pass Xoffset,Yoffset
	}
	public void windowHandling(WebDriver driver,String partialTitle)
	{
		//capture all the ids
		Set<String> allid=driver.getWindowHandles();
		
		//navigate to each window
		for(String id:allid) {
			String currentTitle=driver.switchTo().window(id).getTitle();
			
			//compare the tilte with the required window title
			if(currentTitle.contains(partialTitle))
			{
				break;
			}
		}
	}
	/**
	 * by using this method we take the screenshot of entire web pade
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws Throwable
	 */
	public String screenShot(WebDriver driver,String screenshotname) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		Javautilty jutil=new Javautilty();
		String currentdate=jutil.modifiedDate();
		File des=new File("./screenshot/"+currentdate+screenshotname+".png");
		Files.copy(src, des);//FileHandler.copy(src,des) 
		
		return des.getAbsolutePath();//extent report
	}
	/**
	 * by using this method we will tare the screenshot of particular element
	 * @param element
	 * @param screenshotname
	 * @return
	 * @throws Throwable
	 */
	public String screenShot(WebElement element,String screenshotname) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot)element;
		File src=ts.getScreenshotAs(OutputType.FILE);
		Javautilty jutil=new Javautilty();
		String currentdate=jutil.modifiedDate();
		File des=new File("./screenshot/"+currentdate+screenshotname+".png");
		Files.copy(src, des);//FileHandler.copy(src,des) 
		
		return des.getAbsolutePath();//extent report
	} 
	/**
	 * by using this method we will upload the file
	 * @param path
	 * @param element
	 */
	public void fileupload(String path,WebElement element) {
		File f=new File(path);
		String abpath=f.getAbsolutePath();   //selenium is not taking the relative path we will use absolute path
		element.sendKeys(abpath);
	}
	/**
	 * by using this method to scroll the webpage
	 * @param driver
	 */
	public void scolltheWebpage(WebDriver driver) 
	{
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,500)");
	}
	public void scollTheWebpageElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scollBy(0,"+y+")", element);
	}
	
	/*
	 * this methods are handle frame by WebElement
	 * @param driver
	 * @param element
	 
	public void switchToFrame(WebDriver driver,WebElement element)	
	{
		driver.switchTo().frame(element);
	}
	
	 * this methods are handle frame by NameOrID
	 * @param driver
	 * @param NameOrID
	 
	public void switchToFrame(WebDriver driver,String NameOrID)	
	{
		driver.switchTo().frame(NameOrID);
	}
	/*
	 * this methods are handle frame by index
	 * @param driver
	 * @param index
	 
	public void switchToFrame(WebDriver driver,int index)	
	{
		driver.switchTo().frame(index);
	}
	*/
	public void scrollDownAction(WebDriver driver)
	{
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("window.scrollBy(0,500);","");
	}
	public void scrollUpAction(WebDriver driver)
	{
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("window.scrollBy(0,-500);","");
	}


}
