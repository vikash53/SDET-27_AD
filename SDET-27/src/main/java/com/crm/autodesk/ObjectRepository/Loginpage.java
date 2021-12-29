package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {   //declearation 
	
// identify all the element using @findby ,@findAll,@findbys
	@FindBy(name = "user_name")
	private WebElement userNameEdit;
	
	@FindBy(name = "user_password")
	private WebElement userPasswordEdit;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	
	//exececute allthe element and initilize the element using PageFactory.inElement 
	
	public Loginpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
// decleare all the element priveate and provide getter method and business mehtod for utilization
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}

	public WebElement getUserPasswordEdit() {
		return userPasswordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//business library
	
	public void login(String userName , String password  ) {
		userNameEdit.sendKeys(userName);
		userPasswordEdit.sendKeys(password);
		loginBtn.click();
		
	}

}
