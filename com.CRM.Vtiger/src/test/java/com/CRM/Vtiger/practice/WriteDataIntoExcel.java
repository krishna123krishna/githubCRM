package com.CRM.Vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream ("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.createSheet("TestData");
		sh.createRow(0).createCell(0).setCellValue("dev");
		FileOutputStream fos=new FileOutputStream ("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		

	}

}
