package pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

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

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class SearchProduct_by_Productno {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		//FileInputStream fis = new FileInputStream("./data/commonData.properties");
		//  Properties pObj = new Properties();
		//  pObj.load(fis);
		//   String URL = pObj.getProperty("url");
		//  String USERNAME = pObj.getProperty("username");
		//  String PASSWORD = pObj.getProperty("password");
		//  String BROWSER = pObj.getProperty("browser");
		String ProductName = eLib.getDataFromExcel("product", 1,4);
		String ProductNo = eLib.getDataFromExcel("product", 1, 5);
		//  FileInputStream fis_e = new FileInputStream("./data/testdata.xlsx");
		//  Workbook wb = WorkbookFactory.create(fis_e);
		// Sheet sh = wb.getSheet("product");
		//  Row row = sh.getRow(1);

		// String ProductName = row.getCell(4).getStringCellValue();

		//String ProductNo = row.getCell(5).getStringCellValue();

		WebDriver driver;
		if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if(BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(ProductName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.className("txtBox")).sendKeys(ProductNo);
		WebElement drop = driver.findElement(By.id("bas_searchfield"));
		Select s =new Select(drop);
		s.selectByIndex(0);
		driver.findElement(By.name("submit")).click();
		//logout 
		wLib.mouseOverOnElemnet(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		//Actions act = new Actions(driver);
		//act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		// driver.close();


	}


}


