package com.CRM.Vtiger.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetPractice {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create("fis");
		Sheet sh=wb.getSheet("sheet1");
		Row r=sh.getRow(0);
		Cell cell=r.getCell(0);
		String un=cell.getStringCellValue();
		System.out.println(un);
		
	}

}
