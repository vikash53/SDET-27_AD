package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement  CreateOrgLookUpPageImg;
	 
	@FindBy(xpath = "search_text")
	private WebElement search_textEdit;
	
	@FindBy(xpath = "submit")
	private WebElement searchnowtb;
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgLookUpPageImg() {
		return CreateOrgLookUpPageImg;
	}

	public WebElement getSearch_textEdit() {
		return search_textEdit;
	}

	public WebElement getSearchnowtb() {
		return searchnowtb;
	}
	
	//business library
	public void clickOnCreateOrg()
	{
		 CreateOrgLookUpPageImg.click();
	}
}
