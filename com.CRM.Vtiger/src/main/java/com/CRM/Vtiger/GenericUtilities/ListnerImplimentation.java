package com.CRM.Vtiger.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplimentation implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	
	
	public void onTestStart(ITestResult result) {
		String res=result.getMethod().getMethodName();
		System.out.println(res+" "+"Test Is Started");
		test=report.createTest(res);
		
	}
	
	public void onTestSuccess(ITestResult result) {
		String res=result.getMethod().getMethodName();
		System.out.println(res+" "+"Test Is Successfully Completed");
		test.log(Status.PASS,"Test Script Pass");
	}
	
	
	public void onTestFailure(ITestResult result) {
		
			String res=result.getMethod().getMethodName();
			System.out.println(res+" "+"Test Is Failed");
			test.log(Status.FAIL,"Test Script fail");
			test.log(Status.INFO,result.getThrowable());
			WebDriverutility w=new WebDriverutility();
			Javautilty j=new Javautilty();
			String folname=res+"-"+j.modifiedDate();
			try {
				String path=w.screenShot(BaseClass.Listnerdriver, folname);
				//copy the ss from ss folder then attach the ss into report
				test.addScreenCaptureFromPath(path);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public void onTestSkipped(ITestResult result) {
		
		String res=result.getMethod().getMethodName();
		System.out.println(res+" "+"Test Is Skipped");
		test.log(Status.SKIP,"Testscript Skip");
		test.log(Status.INFO,result.getThrowable());
	}
	
	
	public void onStart(ITestContext context) {
System.out.println("Suite is Started");
		
		//to system configuration
		ExtentSparkReporter rep=new ExtentSparkReporter("./ExtentReport\\Report-"+new Javautilty().modifiedDate()+".html");
		rep.config().setDocumentTitle("Execution Report");
		rep.config().setTheme(Theme.DARK);
		rep.config().setReportName("V Tiger Rport");
		
		//to report configuration
		report=new ExtentReports();
		report.attachReporter(rep);
		report.setSystemInfo("browser","chrome");
		report.setSystemInfo("url","http://localhost:8888");
		report.setSystemInfo("platform","window 11 pro");
		report.setSystemInfo("reporter name","krishna");
	}
	
	
	public void onFinish(ITestContext context) {
System.out.println("Suite is Ended");
		
		//to consolidate the report and to replace the old report with new one
		report.flush();
		 
	}

}
