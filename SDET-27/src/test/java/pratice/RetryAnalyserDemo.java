package pratice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserDemo {

	@Test(retryAnalyzer = com.crm.autodesk.genericutility.RetryAnalyserImp.class)
	public void RetryAnalyserDemoTest()
	{
		System.out.println("RetryAnlyser");
		Assert.fail();
	}
}
