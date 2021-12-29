package com.crm.autodesk.genericutility;

import java.util.Date;
import java.util.Random;
/**
 * 
 * @author vikash kumar
 *
 */

public class JavaUtility {
	/**
	 * its used to generate random number 
	 * @return int data
	 */
public int getRanDomNumber() {
	Random random = new Random();
	int intRandom = random.nextInt(1000);
	return intRandom;
}
/**
 * used to get system date & time in IST formate
 * @return
 */
public String getSystemDataAndTime() {
	Date date = new Date();
	return date.toString();
}
public String getSystemDateWithFormate() {
	Date date = new Date();
	String dateAndTime = date.toString();
	 String yyyy = dateAndTime.split(" ")[5];
	 String DD = dateAndTime.split(" ")[2];
int MM = date.getMonth()+1;
String finalFormate = yyyy+"-"+MM+"-"+DD;
return finalFormate;
	 
}
     
	}


