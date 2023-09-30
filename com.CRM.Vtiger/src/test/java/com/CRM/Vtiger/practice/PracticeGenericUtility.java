package com.CRM.Vtiger.practice;

import com.CRM.Vtiger.GenericUtilities.ExcelFileutility;
import com.CRM.Vtiger.GenericUtilities.Fileutility;
import com.CRM.Vtiger.GenericUtilities.Javautilty;

public class PracticeGenericUtility {

	public static void main(String[] args) throws Throwable {
		Fileutility file=new Fileutility();
		String browser=file.getdataFromPropertyFile("browser");
		System.out.println(browser);
		ExcelFileutility eutil=new ExcelFileutility();
		String contactname=eutil.getDataformExcelSheet("TestData", 0, 0);
		System.out.println(contactname);
		
		//call the current date  n times
		Javautilty jutil=new Javautilty();
		 String date=jutil.sysdateTime();
		 System.out.println(date);
		 
		 String dat=jutil.modifiedDate();
		 System.out.println(dat);

	}

}
