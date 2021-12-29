package pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateContactWithOrgGeneralLibraryTestt {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		
		
		 
		 String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		
		int randomnum = jLib.getRanDomNumber();
		
		
		   String contact = eLib.getDataFromExcel("contact", 1, 2) + randomnum;
		  
		   
		   
		   String org = eLib.getDataFromExcel("org", 1, 2)+ randomnum;
		   
		   WebDriver driver = null;
		   if(BROWSER.equals("firefox")) {
			   driver = new FirefoxDriver();
		   }
		   else if(BROWSER.equals("chrome")){
			   driver = new ChromeDriver();
			   
		   }
		   else if (BROWSER.equals("interexplo")) {
			   driver = new InternetExplorerDriver();
			   
		   }
		  
		   wLib.waitForPageTOLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys(org);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		wLib.waitForElementToBeClickAble(driver,driver.findElement(By.className("dvHeaderText")));
		
	
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys(contact);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
    
		wLib.swithToWindow(driver, "Accounts");
		
		
     
     driver.findElement(By.name("search_text")).sendKeys(org);
     driver.findElement(By.name("search")).click();
     driver.findElement(By.xpath("//a[text()='"+org+"']")).click();
     
     
     wLib.swithToWindow(driver, "Contacts");
      
     
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actsucc_msg = driver.findElement(By.className("dvHeaderText")).getText();
		if(actsucc_msg.contains(contact)) {
			System.out.println("contact is successfully created with org : pass");
			
		}
		else {
			System.out.println("contact is not created with org :fail");
		}

		String actsucc_orgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actsucc_orgname.contains(org)) {
			System.out.println("orgname is successfully created with org : pass");
			
		}
		else {
			System.out.println("orgname is not created with org :fail");
		}
		
		
		wLib.mouseOverOnElemnet(driver,driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
	


	

	}


