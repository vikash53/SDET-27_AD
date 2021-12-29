package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
@FindBy(xpath = "//img[@alt='Create Product...']")
 private WebElement CreatProductLookPage;

public ProductPage(WebDriver driver)
{
PageFactory.initElements(driver, this);
}

public WebElement getCreatProductLookPage() {
	return CreatProductLookPage;
}
// business library for 
public void clickOnCreatProduct()
{
	CreatProductLookPage.click();
}
}
