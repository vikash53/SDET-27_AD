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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.Loginpage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodesk.ObjectRepository.OrganizationinfoPage;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateOrgWithIndustries_Type  {

	public static void main(String[] args) throws Throwable   {
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		
		int randomnum = jLib.getRanDomNumber();

		String orgName = eLib.getDataFromExcel("org", 1, 2)+randomnum;
		String indusname = eLib.getDataFromExcel("org", 1, 7);
		 String typeName = eLib.getDataFromExcel("org", 1, 8);


		 WebDriver driver;
if(BROWSER.contentEquals("firefox")) {
	 driver = new FirefoxDriver();
}else if(BROWSER.equals("chrome")) {
	 driver = new ChromeDriver();
} else if(BROWSER.equals("ie")){
driver = new InternetExplorerDriver();
} else {
	 driver = new ChromeDriver();
}
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
driver.get(URL);

//login
Loginpage lp = new Loginpage(driver);
lp.login(USERNAME, PASSWORD);


HomePage hp = new HomePage(driver);
hp.clickOnOrganizationsLink();


OrganizationPage op = new OrganizationPage(driver);
    op.clickOnCreateOrg();

   CreateOrganizationPage cop = new CreateOrganizationPage(driver);
    cop.creatorgWithindustry(orgName, "Energy");
//driver.findElement(By.name("accountname")).sendKeys(orgName);
    OrganizationinfoPage oip = new OrganizationinfoPage(driver);
     String Actmsg = oip.getorginfo();
    
if (Actmsg.contains(orgName)) {
	System.out.println("org is created with industry");
} else {
	System.out.println("organisation is not created with industry");
}
hp.logout(driver);
driver.quit();
	
 
 
 
 


	}

}
