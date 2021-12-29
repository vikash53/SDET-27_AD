package com.crm.autodesk.genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		
	}

	public void onTestFailure(ITestResult result) {
		// capture methodname
		String methodName = result.getMethod().getMethodName();
		//capture the current date 
		
	 String CurrentDate = new JavaUtility().getSystemDateWithFormate();
	 
	 // concatenate for Screenshootname 
	 String screenshotName = methodName+"_"+CurrentDate;
	 
	 try {
		 new WebDriverUtility().takeScreenshot(BaseClass.sdriver, screenshotName);
	 }catch (Throwable e) {
		 e.printStackTrace();
	 }
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
