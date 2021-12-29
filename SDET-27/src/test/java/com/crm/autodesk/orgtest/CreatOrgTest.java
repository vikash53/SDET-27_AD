package com.crm.autodesk.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.Loginpage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodesk.ObjectRepository.OrganizationinfoPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

@Listeners(com.crm.autodesk.genericutility.ListenerImplementation.class)
public class CreatOrgTest extends BaseClass {
	@Test(groups = "smokeSuite")
	public void creatOrgTest() throws Throwable {

		int ranDomNum = jLib.getRanDomNumber();

		String orgName = eLib.getDataFromExcel("org", 1, 2)+ranDomNum;

		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		// steps 3: click on the creat organisation button

		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrg();
		
		//Assert.fail();
		// steps 4: enter all the details and creat new organisation
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.creatorg(orgName);
		
		
		
		//step :5 verift the organisation is in the name of the header 
		OrganizationinfoPage opi= new OrganizationinfoPage(driver);
		String actSuc_msg = opi.getorginfo();
		
		Assert.assertTrue(actSuc_msg.contains(orgName));
		System.out.println("org is sucessfully created and pass");
		
        
		/*if (actSuc_msg.contains(orgName)) {
			System.out.println(actSuc_msg);
			System.out.println("org is sucessfully created and pass");
		}
		else {
			System.out.println("orgnation is not created ...fail");
		} */
	}
	@Test
	public void createOrgDemo()
	{
		System.out.println("demo");
	}
	
}















