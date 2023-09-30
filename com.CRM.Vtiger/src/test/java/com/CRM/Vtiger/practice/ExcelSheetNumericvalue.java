package com.CRM.Vtiger.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelSheetNumericvalue {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		//1] to avoid illegalStateException in the below case use '10 in the excel sheet and save
		String value=wb.getSheet("sheet2").getRow(0).getCell(0).getStringCellValue();
		System.out.println(value);
		
		//2] to avoid illegalStateException in the below case use to override the toString()
		String value1=wb.getSheet("sheet2").getRow(0).getCell(0).toString();
		System.out.println(value1);
		
		//3] to avoid illegelStateException in the below case use
		/*create object of DataFormatter and use formatCellValue*/
		DataFormatter df=new DataFormatter();
		String value2=df.formatCellValue(wb.getSheet("sheet2").getRow(0).getCell(0));
		System.out.println(value2);
	}

}
