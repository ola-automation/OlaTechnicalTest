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
import com.bjss.pages.actions.OrderHistoryAndDetailsPage;
import com.bjss.pages.actions.SigninPage;
import com.bjss.utilities.Utilities;

public class ReviewOrderAddCommentTest {
	
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void reviewOrderAddCommentTest(Hashtable<String, String> data) {

		if (data.get("runmode").equalsIgnoreCase("N")) {

			throw new SkipException("Skipping the test as the Run mode is NO");
		}
		
		Page.initConfiguration();
		HomePage homePage = new HomePage();
		SigninPage signinPage = homePage.goToSigninPage();
		MyAccountPage myAccountPage = signinPage.doLogin(Constants.email, Constants.password);
		OrderHistoryAndDetailsPage orderHistoryAndDetailsPage = myAccountPage.goToOrderHistoryAndDetailsPage();
		String orderHistoryDate = orderHistoryAndDetailsPage.getOrderDate();
		String orderReference = orderHistoryAndDetailsPage.getOrderReference();
		
		String assertsOrderHistoryDate = data.get("orderDate");
		String assertOrderReference = data.get("orderReference");
		
		System.out.println("orderHistoryDate : " + orderHistoryDate);
		System.out.println("orderReference : " + orderReference);
		System.out.println("assertsOrderHistoryDate : " + assertsOrderHistoryDate);
		System.out.println("assertOrderReference : " + assertOrderReference);
		
		Assert.assertEquals(orderHistoryDate, assertsOrderHistoryDate, "The order history date on Order Details page: " + orderHistoryDate + " is supposed to orderHistory date captured from the pervious testcase: " + assertsOrderHistoryDate);
		Assert.assertEquals(orderReference, assertOrderReference, "The order referfence on Order Details page: " + orderReference + " is supposed to orderHistory date captured from the pervious testcase: " + assertOrderReference);
		
		orderHistoryAndDetailsPage.selectFirstOrderReference();
		String messageSent = orderHistoryAndDetailsPage.leaveMessage();
		String assertMessage = orderHistoryAndDetailsPage.getMessageSent();
		
		Assert.assertEquals(messageSent, assertMessage, "The message left in the orders page is: " + messageSent + " is supposed to match the message gotten after the message was put on the page: " + assertMessage);
	}
	
	@AfterMethod
	public void tearDown(){
		if(Page.driver!=null){
		Page.quitBrowser();
		}
	}

}
