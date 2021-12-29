package com.crm.autodesk.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.Loginpage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateContactWithOrgTest extends BaseClass {

	@Test(groups = "RegressionSuite")
	public void CreateContactWithOrgTest() throws Throwable {

		int randomnum = jLib.getRanDomNumber();

		String contact = eLib.getDataFromExcel("contact", 1, 2) + randomnum;
		String org = eLib.getDataFromExcel("org", 1, 2)+ randomnum;

		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrg();
		CreateOrganizationPage co = new CreateOrganizationPage(driver);
		co.creatorg(org); 

		Thread.sleep(10000);
		hp.ClickOncontactLink();
		ContactsPage cp= new ContactsPage(driver);
		cp.clickOncreatcontactlookupimg();

		CreateContactPage cpp= new CreateContactPage(driver);
		cpp.createcontactwithorg(driver, contact, org);
	}
}












/*hp.ClickOncontactLink();

		ContactsPage cp = new ContactsPage(driver);
     cp.clickOncreatcontactlookupimg();

    // CreateContactPage ccp = new CreateContactPage(driver);
     ccp.creatContact(contact);

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
		driver.quit();*/









