package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
 @FindBy(xpath = "//img[@alt='Create Contact...']")
private WebElement creatcontactlookupimg;
 
 @FindAll({@FindBy(name ="search_text" ),@FindBy(xpath ="//input[@class='txtBox']")})
 public  WebElement serchtextEdt;
 
 @FindBy(name = "submit")
 WebElement searchnowBtn;
 
 public ContactsPage(WebDriver driver)
 
 {
	 PageFactory.initElements(driver, this);
	 
 }

public WebElement getCreatcontactlookupimg() {
	return creatcontactlookupimg;
}

public WebElement getSerchtextEdt() {
	return serchtextEdt;
}

public WebElement getSearchnowBtn() {
	return searchnowBtn;
}
 
 //business library
public void  clickOncreatcontactlookupimg()
{ 
	creatcontactlookupimg.click();
}
 
}
