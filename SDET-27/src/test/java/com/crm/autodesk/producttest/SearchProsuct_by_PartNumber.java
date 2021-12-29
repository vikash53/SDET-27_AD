package com.crm.autodesk.producttest;

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

import com.crm.autodesk.ObjectRepository.CreateProductPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.Loginpage;
import com.crm.autodesk.ObjectRepository.ProductPage;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class SearchProsuct_by_PartNumber {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");	 
		// FileInputStream fis = new FileInputStream("./data/commonData.properties");
		// Properties pObj = new Properties();
		//  pObj.load(fis);
		//  String URL = pObj.getProperty("url");
		// String USERNAME = pObj.getProperty("username");
		//  String PASSWORD = pObj.getProperty("password");
		//  String BROWSER = pObj.getProperty("browser");

		String ProductName = eLib.getDataFromExcel("product", 1, 4);
		String PartNumber = eLib.getDataFromExcel("product", 1, 6);
		//  FileInputStream fis_e = new FileInputStream("./data/testScriptData.xlsx");
		//   Workbook wb = WorkbookFactory.create(fis_e);
		//  Sheet sh = wb.getSheet("product");
		//   Row row = sh.getRow(1);
		//   String ProductName = row.getCell(4).getStringCellValue();
		//    String PartNumber = row.getCell(6).getStringCellValue();





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
		
		// login 
		Loginpage lp  = new  Loginpage(driver);
		lp.login(USERNAME, PASSWORD);
		
		
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		HomePage hp =new  HomePage(driver);
		hp.ClickOnProductLink();
		
		//driver.findElement(By.linkText("Products")).click();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		ProductPage pp = new ProductPage(driver);
		pp.clickOnCreatProduct();
		
		
		//driver.findElement(By.name("productname")).sendKeys(ProductName);
		//driver.findElement(By.id("productcode")).sendKeys(PartNumber);
		CreateProductPage ccp= new CreateProductPage(driver);
		ccp.productWithProductNameAndPartName(ProductName, PartNumber);
		
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.className("txtBox")).sendKeys(PartNumber);
		WebElement drop = driver.findElement(By.id("bas_searchfield"));
		Select s =new Select(drop);
		s.selectByIndex(2);
		driver.findElement(By.name("submit")).click();

wLib.mouseOverOnElemnet(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		//Actions act = new Actions(driver);
		//act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		//driver.close();

	}

}
