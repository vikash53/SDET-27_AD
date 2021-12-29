package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
  @FindBy(name = "accountname")
 private WebElement OrganizationNameEdt;
  
  @FindBy(name = "industry")
 private WebElement industryDropDown;
  
  
  
  
  @FindBy(name = "accounttype")
  private WebElement typrDropDown;
  
  @FindBy(xpath = "//input[@title='Save [Alt+S]']")
 private WebElement savebtn;
  
  public CreateOrganizationPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }

public WebElement getOrganizationNameEdt() {
	return OrganizationNameEdt;
}

public WebElement getIndustryDropDown() {
	return industryDropDown;
}

public WebElement getTyprDropDown() {
	return typrDropDown;
}

public WebElement getSavebtn() {
	return savebtn;
}
  
  //business library for creat organisation
public void creatorg(String orgName)
{
	OrganizationNameEdt.sendKeys(orgName);
	savebtn.click();
}
//business library for creat organisation with industry drop down

public void creatorgWithindustry(String orgName ,String industryType )
{
	OrganizationNameEdt.sendKeys(orgName);
	select(industryDropDown ,industryType);
	savebtn.click();
	
}
	  
}
