package com.crm.autodesk.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.Loginpage;

public class BaseClass {
	public DataBaseUtility dLib = new DataBaseUtility();
	public ExcelUtility eLib= new ExcelUtility ();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite (groups = {"smokeSuite","RegressionSuite"})
	public void dbConnection() {
		dLib.connectionToDB();
		System.out.println("connection establishes to application ");
	}

	//@Parameters("browser")
	@BeforeClass(groups = {"smokeSuite","RegressionSuite"})
	public void launchBrowser() throws Throwable {
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("ie")) {
			driver= new InternetExplorerDriver();
		}else {
			System.out.println("invalid broser ");
		}
		sdriver=driver;
		wLib.waitForPageTOLoad(driver);
		wLib.maximizeWindow(driver);
		driver.get(URL);
		System.out.println("-- launch the browser ---- ");
	}
	// login the application 
	@BeforeMethod(groups = {"smokeSuite","RegressionSuite"})
	public void loginToApp() throws Throwable {
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");

		Loginpage lp= new Loginpage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("---login sucessfull to application---");
	}

	// steps to logout 
	@AfterMethod(groups = {"smokeSuite","RegressionSuite"})
	public void logOutApp() {
		HomePage hp = new HomePage(driver);
		hp.logout(driver);
		System.out.println("---logout  sucessfull to application---");
	}
	// steps to close the browser 
	@AfterClass(groups = {"smokeSuite","RegressionSuite"})
	public void closeBrowser() {
		driver.quit();
		System.out.println("---close the application application---");
	}

	//close the connection to application
@AfterSuite(groups = {"smokeSiute","RegressionSuite"})
	public void closeConnection () {
		dLib.closeDB();
		System.out.println("---database connection close sucessfully ---");
	}





}


