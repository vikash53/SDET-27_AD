package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
	@FindBy(name = "lastname")
	private WebElement contactlastNameEdt;
	
	
	
	
	@FindBy(name = "search_text")
	 private  WebElement orgserchtextEdt;
	  
	  
	  @FindBy(name = "search")
	 private WebElement searchnowbtn;
	  
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement OrglookUpImg;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public CreateContactPage(WebDriver driver )
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getContactlastNameEdt() {
		return contactlastNameEdt;
	}
	public WebElement getOrglookUpImg() {
		return OrglookUpImg;
	}
	//business library for creatorganisation
	
	public void creatContact(String lastname)
	{
	contactlastNameEdt.sendKeys(lastname);
	savebtn.click();
	}
	//business library create contact with organisation 
	
	public void createcontactwithorg(WebDriver driver , String lastname, String orgName)
	{
		contactlastNameEdt.sendKeys(lastname);
		OrglookUpImg.click();
		swithToWindow(driver,"Accounts");
		orgserchtextEdt.sendKeys(orgName);
		searchnowbtn.click();
		driver.findElement(By.linkText(orgName)).click();
		swithToWindow(driver,"Contacts");
		savebtn.click();
	}
	
	
	
}

