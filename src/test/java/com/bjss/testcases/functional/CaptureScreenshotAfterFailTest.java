package com.bjss.testcases.functional;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.bjss.base.Constants;
import com.bjss.base.Page;
import com.bjss.pages.actions.HomePage;
import com.bjss.pages.actions.MyAccountPage;
import com.bjss.pages.actions.SigninPage;
import com.bjss.utilities.Utilities;

public class CaptureScreenshotAfterFailTest {
	
	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void captureScreenshotAfterFailTest(Hashtable<String,String> data) {
		
		if(data.get("runmode").equalsIgnoreCase("N")){
			
			throw new SkipException("Skipping the test as the Run mode is NO");	
		}
		
		Page.initConfiguration();
		HomePage homePage = new HomePage();
		SigninPage signinPage = homePage.goToSigninPage();
		MyAccountPage myAccountPage = signinPage.doLogin(Constants.email, Constants.password);
		myAccountPage.goToHomePage();
		String intentionalFailString = homePage.getIntentionalFailText();
		String assertFail = data.get("assertFail");
		
		System.out.println("intentionalFailString : " + intentionalFailString);
		System.out.println("assertFail : " + assertFail);

		Assert.assertEquals(intentionalFailString, assertFail, "The String : " + assertFail + " is meant to differ from: " + intentionalFailString + " to cause an intentional fail so a screenshot can be taken!" );
	}
	
	
	@AfterMethod
	public void tearDown(){
		if(Page.driver!=null){
		Page.quitBrowser();
		}
	}
	
}
