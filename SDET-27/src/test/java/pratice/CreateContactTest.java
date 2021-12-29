package pratice;

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

import com.crm.autodesk.ObjectRepository.ContactInfoPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.Loginpage;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateContactTest {


	public static void main(String[] args) throws Throwable {
FileUtility fLib = new FileUtility();
ExcelUtility eLib = new ExcelUtility();
WebDriverUtility wLib= new WebDriverUtility();
JavaUtility jLib= new JavaUtility();

String URL = fLib.getPropertyKeyValue("url");
String USERNAME = fLib.getPropertyKeyValue("username");
String PASSWORD = fLib.getPropertyKeyValue("password");
String BROWSER = fLib.getPropertyKeyValue("browser");

		//FileInputStream fis = new FileInputStream("./data/commonData.properties");
		//Properties PObj = new Properties();
		//PObj.load(fis);
		//String URL = PObj.getProperty("url");
		//String USERNAME = PObj.getProperty("username");
		//String PASSWORD = PObj.getProperty("password");
		//String BROWSER = PObj.getProperty("browser");

String ContactName = eLib.getDataFromExcel("contact", 1, 2);

		//FileInputStream fise = new FileInputStream("./data/testScriptData.xlsx");
		//Workbook wb = WorkbookFactory.create(fise);
		//Sheet sh = wb.getSheet("contact");
		//Row row = sh.getRow(1);
		//String ContactName = row.getCell(2).getStringCellValue();


//wLib.waitForPageTOLoad(driver);
		WebDriver driver=null;
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
		Loginpage lp=new Loginpage(driver);
		lp.login(USERNAME, PASSWORD);
		HomePage hp = new HomePage(driver);
		hp.ClickOncontactLink();

		ContactsPage cp = new ContactsPage(driver);
		cp.clickOncreatcontactlookupimg();
		
		CreateContactPage ccp= new CreateContactPage(driver);
		ccp.creatContact(ContactName);

		ContactInfoPage cip = new ContactInfoPage(driver);

		
		String actSuc_msg = cip.getconnectinfo();
		if(actSuc_msg.contains(ContactName)) {
			System.out.println(" contact created sucessfully ....pass ");
		} else {
			System.out.println("contact  not created ...fail");
		}
		//steps:6 logout 
		hp.logout(driver);
		driver.quit();
	}
}

	

