package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
  @FindBy(linkText = "Organizations")
 private WebElement OrganizationsLink;
  
  @FindBy(linkText = "Contacts")
 private WebElement ContactsLink;
  
  @FindBy(linkText = "Opportunities")
   private WebElement Opportunitieslink;
  
  @FindBy(linkText = "Products")
 private  WebElement ProductsLink;
  
  @FindBy(linkText = "Documents")
 private  WebElement DocumentsLink;
  
  @FindBy(linkText = "Trouble Tickets")
 private WebElement TroubleTicketsLink;
  
  @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
 private WebElement administratorImg;
  
  @FindBy(linkText = "Sign Out")
  private WebElement SignOutLink;
  
  public HomePage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
	  
  }

public WebElement getOrganizationsLink() {
	return OrganizationsLink;
}

public WebElement getContactsLink() {
	return ContactsLink;
}

public WebElement getOpportunitieslink() {
	return Opportunitieslink;
}

public WebElement getProductsLink() {
	return ProductsLink;
}

public WebElement getDocumentsLink() {
	return DocumentsLink;
}

public WebElement getTroubleTicketsLink() {
	return TroubleTicketsLink;
}

public WebElement getAdministratorImg() {
	return administratorImg;
}

public WebElement getSignOutLink() {
	return SignOutLink;
}
  
  //business library to click on organisations
  public void clickOnOrganizationsLink()
  {
	  OrganizationsLink.click();
  }
  // business library to click on contacts
  
  public void ClickOncontactLink()
  {
	  ContactsLink.click();
  }
  //business library for logout 
  public void logout(WebDriver driver)
  {
mouseOverOnElemnet(driver,administratorImg);
SignOutLink.click();

  }
  //business library for product link
  public void ClickOnProductLink() {
	  ProductsLink.click();
  }
  
  }
  

