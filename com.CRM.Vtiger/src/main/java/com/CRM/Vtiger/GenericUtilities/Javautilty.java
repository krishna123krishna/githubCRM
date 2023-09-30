package com.CRM.Vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

public class Javautilty {
	/**
	 * this method help us to generate random number
	 * @return
	 */
	
	public int getrandom()
	{
		Random r=new Random();
		return r.nextInt(1000);
	}
	/**
	 * This method return system date and time 
	 * @return
	 */
	public String sysdateTime() 
	{
		Date d =new Date();//date add java.util.Date
		String date=d.toString();
		return date;
	}
	public String modifiedDate()
	{
		Date d=new Date();
		String[] date=d.toString().split(" ");
		String dt=date[2];
		String month=date[1];
		String time=date[3].replace(":", "-");
		String year=date[5];
		String currentdate=dt+" "+time+" "+month+" "+year;
		return currentdate;
	}
	
	

}
