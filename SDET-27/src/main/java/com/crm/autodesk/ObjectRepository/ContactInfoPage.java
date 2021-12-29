package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	
@FindBy(className = "dvHeaderText")
private WebElement creatHeaderinfoText;


public ContactInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getCreatHeaderinfoText() {
	return creatHeaderinfoText;
}
//business library
public String getconnectinfo()
{
	return(creatHeaderinfoText.getText());
}
}

