package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author vikash kumar
 *
 */

public class FileUtility {
	/**
	 * its used to read the data from commonData.properties File based on Key which you pass as an 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
    public String getPropertyKeyValue(String key) throws Throwable {
    	FileInputStream fis = new FileInputStream("./data/commonData.properties");
    	Properties pobj = new Properties();
    	pobj.load(fis);
    	String value = pobj.getProperty(key);
		return value;
    	
    	
    }
}
