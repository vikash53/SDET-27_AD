package com.crm.autodesk.contacttest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactInfoPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.Loginpage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateContactTest extends BaseClass {
	@Test(groups = "smokeSuite")
	public void CreateContactTest () throws Throwable {

		String ContactName = eLib.getDataFromExcel("contact", 1, 2);

		HomePage hp = new HomePage(driver);
		hp.ClickOncontactLink();

		ContactsPage cp = new ContactsPage(driver);
		cp.clickOncreatcontactlookupimg();

		CreateContactPage ccp= new CreateContactPage(driver);
		ccp.creatContact(ContactName);

		ContactInfoPage cip = new ContactInfoPage(driver);

		String actSuc_msg = cip.getconnectinfo();
		
		
		Assert.assertTrue(actSuc_msg.contains(ContactName));
		System.out.println(" contact created sucessfully ....pass ");
		
		/*if(actSuc_msg.contains(ContactName)) {
			System.out.println(" contact created sucessfully ....pass ");
		} else {
			System.out.println("contact  not created ...fail");
		}*/

	}
}



