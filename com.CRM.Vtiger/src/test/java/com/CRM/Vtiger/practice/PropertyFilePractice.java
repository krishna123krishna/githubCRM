package com.CRM.Vtiger.practice;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream ("./src/test/resources/CommonData.Properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER=pobj.getProperty("brows er");
		System.out.println(BROWSER);
		
	}

}
