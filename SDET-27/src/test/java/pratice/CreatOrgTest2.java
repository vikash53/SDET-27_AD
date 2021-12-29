package pratice;

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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

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

public class CreatOrgTest2 extends BaseClass {

	@Test
	public void CreatOrgTest() throws Throwable {

	int ranDomNum = jLib.getRanDomNumber();

	String orgName = eLib.getDataFromExcel("org", 1, 2)+ranDomNum;

	//step 2: navigate to Organisation Module
	HomePage hp = new HomePage(driver);
	hp.clickOnOrganizationsLink();
	// steps 3: click on the creat organisation button

	OrganizationPage op = new OrganizationPage(driver);
	op.clickOnCreateOrg();
	// steps 4: enter all the details and creat new organisation
	CreateOrganizationPage cop = new CreateOrganizationPage(driver);
	cop.creatorg(orgName);
	//step :5 verift the organisation is in the name of the header 
	OrganizationinfoPage opi= new OrganizationinfoPage(driver);
	String actSuc_msg = opi.getorginfo();

	if (actSuc_msg.contains(orgName)) {
		System.out.println(actSuc_msg);
		System.out.println("org is sucessfully created and pass");
	}
	else {
		System.out.println("orgnation is not created ...fail");
	} 

	hp.logout(driver);

	driver.quit();
}






}






