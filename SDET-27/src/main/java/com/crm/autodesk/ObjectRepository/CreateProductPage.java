package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateProductPage extends WebDriverUtility {
	@FindBy(name = "productname")
	private  WebElement productNameEdit;
	@FindBy(name = "productcode")
	private WebElement partNumberEdit;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtnEdit;
	
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}

	public WebElement getProductNameEdit() {
		return productNameEdit;
	}

	public WebElement getPartNumberEdit() {
		return partNumberEdit;
	}

	public WebElement getSavebtnEdit() {
		return savebtnEdit;
	}
	// business library 
	
	public void productWithProductNameAndPartName(String productName ,String partNumber)
	{
		productNameEdit.sendKeys(productName);
		partNumberEdit.sendKeys(partNumber);
		savebtnEdit.click();
	}

}
