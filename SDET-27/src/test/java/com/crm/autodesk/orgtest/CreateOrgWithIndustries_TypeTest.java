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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

public class CreateOrgWithIndustries_TypeTest extends BaseClass {
	@Test(groups = "RegressionSuite")

	public void CreateOrgWithIndustries_TypeTest() throws Throwable {


		int randomnum = jLib.getRanDomNumber();

		String orgName = eLib.getDataFromExcel("org", 1, 2)+randomnum;
		String indusname = eLib.getDataFromExcel("org", 1, 7);
		String typeName = eLib.getDataFromExcel("org", 1, 8);




		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();


		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrg();

		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.creatorgWithindustry(orgName, "Energy");
		OrganizationinfoPage oip = new OrganizationinfoPage(driver);
		String Actmsg = oip.getorginfo();
		
		SoftAssert sa= new SoftAssert();
		sa.assertTrue(Actmsg.contains(orgName));
		System.out.println("org is created with industry");
		sa.assertAll();

	/*	if (Actmsg.contains(orgName)) {
			System.out.println("org is created with industry");
		} else {
			System.out.println("organisation is not created with industry");
		}*/








	}

}
