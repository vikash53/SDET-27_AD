package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationinfoPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeadertext;
	
	public OrganizationinfoPage(WebDriver driver)
	{
	PageFactory.initElements(driver,this );
	}

	public WebElement getOrgHeadertext() {
		return orgHeadertext;
	}
	// business library 
	public String getorginfo( )
	{
		return(orgHeadertext.getText());
	}
	

}
