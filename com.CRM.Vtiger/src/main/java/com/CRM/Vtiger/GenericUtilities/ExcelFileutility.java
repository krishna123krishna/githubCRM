package com.CRM.Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelFileutility {
	
	
	public String getDataformExcelSheet(String sheetname,int row,int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(Ipath.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	public void updateExcelData(String sheetname,int row,int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(Ipath.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		FileOutputStream fos=new FileOutputStream(Ipath.excelfilepath);
		wb.write(fos);
	}
	@DataProvider
	public Object[][] multipleData() throws Throwable
	{
		FileInputStream f=new FileInputStream(Ipath.excelfilepath);
		Sheet s=WorkbookFactory.create(f).getSheet("Sheet2");
		int row=s.getLastRowNum()+1;
		int cell=s.getRow(0).getLastCellNum();
		Object[][] ob=new Object[row][cell];
		DataFormatter da=new DataFormatter();
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<cell;j++)
			{
				ob[i][j]=da.formatCellValue(s.getRow(i).getCell(j));
			}
		}
		return ob;
	}
}
