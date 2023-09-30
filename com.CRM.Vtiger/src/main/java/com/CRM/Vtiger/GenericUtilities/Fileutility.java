package com.CRM.Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * this class consist of generic method to fetch the data from property file
 * @author krishna
 *
 */

public class Fileutility {
	
	/**
	 * this method help us to fetch the data from property file
	 * @krishna
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String getdataFromPropertyFile(String key) throws Throwable {

		
		FileInputStream fis=new FileInputStream(Ipath.propertyfilepath);
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
		
	}

}
