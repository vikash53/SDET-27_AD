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

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.Loginpage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodesk.ObjectRepository.OrganizationinfoPage;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreatOrgTest extends WebDriverUtility {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility    wLib =new WebDriverUtility();

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

		int ranDomNum = jLib.getRanDomNumber();

		//getRanDom num
		//Random ran = new Random();
		// int ranDomNum = ran.nextInt(10000);
		String orgName = eLib.getDataFromExcel("org", 1, 2)+ranDomNum;
		//FileInputStream fise = new FileInputStream("./data/testdata.xlsx");
		//Workbook wb = WorkbookFactory.create(fise);
		// Sheet sh = wb.getSheet("org");
		//Row row = sh.getRow(1);
		//String orgName = row.getCell(2).getStringCellValue()+ranDomNum;



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

		
		wLib.waitForPageTOLoad(driver);
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(URL);
		//steps 1: login
		Loginpage lp = new Loginpage(driver);
		lp.login(USERNAME, PASSWORD);
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






