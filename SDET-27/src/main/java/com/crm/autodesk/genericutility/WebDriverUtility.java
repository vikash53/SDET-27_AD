package com.crm.autodesk.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.mysql.cj.jdbc.Driver;




public class WebDriverUtility {
/**
 * wait for the page to load before identifying any sychronizaton element in Dom [HTML-Document]
 * @param driver
 */
public void waitForPageTOLoad(WebDriver driver)  {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
}
/**
 * wait for page to load before identifying any assychronized[java scripts actions] element in DOM [HTML-Document]
 * @param driver
 */

public void waitForPageToLoadForJsElement(WebDriver driver) {
	driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
}
/**
 * 
 * @param driver
 * @param element
 */



public void waitForElementToBeClickAble(WebDriver driver,WebElement element ) {
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
	/**
	 * 
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @throws Throwable 
	 */
	
	
	public void waitForElementWithCumtomTimeOut(WebDriver driver,WebElement element,int pollingTime) throws Throwable {
		
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime,TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	
	public void  swithToWindow(WebDriver driver,String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while (it.hasNext()) {
		String wID = it.next();
		driver.switchTo().window(wID);
		String currentWindowTitle = driver.getTitle();
		if(currentWindowTitle.contains(partialWindowTitle)) {
			break;
		}
		}
		}
	/**
	 * use to switch to Alert Window & click on ok button
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * use to switch to Alert Window & click on cancel button
	 * @param driver
	 */
	public void SwitchToWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to switch to Frame Window on index
	 * @param driver
	 * @param index
	 */
	
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * 
	 * @param driver
	 * @param id_name_attribute
	 */
	
	public void switchToFrame(WebDriver driver ,String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
		
	}
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param element
	 * @param index
	 */
	
	public void select(WebElement element ,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropDwon  based on value / option avlaible in GUI
	 * @param element
	 * @param value
	 */
	public void select(WebElement element , String text) {
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
		
		}
	/**
	 * 
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOverOnElemnet(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param elemnet
	 */

	public void rightClickOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver , String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}
	
	   public void waitAndClick(WebElement element) throws InterruptedException{
	   
		   int count = 0;
	       while(count<20) {
		    	   try {
		    	       element.click();
		    	       break;
		    	   }catch(Throwable e){
		    	   
		    		   
		    		   Thread.sleep(1000);
		    		   count++;
		    	   }
	       }
	   }

	   /**
	    * used for the screenshot
	    * @param driver
	    * @param screenshotName
	    * @throws Exception
	    */

public void takeScreenshot(WebDriver driver,String screenshotName) throws Exception {
	TakesScreenshot ts=(TakesScreenshot)driver;
	 File src = ts.getScreenshotAs(OutputType.FILE);
	 File dest=new File("./screenshot/"+screenshotName+".PNG");
     Files.copy(src, dest);
}

/**
 * pass enter Key appertain in to Browser
 * @param driver
 */
public void passEnterKey(WebDriver driver) {
   Actions act = new Actions(driver);
   act.sendKeys(Keys.ENTER).perform();
} 
/**
 * it maximize the window 
 * @param driver
 */

public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
			
}

}
	    	   

	



