package com.bjss.testcases.functional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.bjss.base.Constants;
import com.bjss.base.Page;
import com.bjss.pages.actions.AddressPage;
import com.bjss.pages.actions.HomePage;
import com.bjss.pages.actions.MyAccountPage;
import com.bjss.pages.actions.OrderConfirmationPage;
import com.bjss.pages.actions.PaymentPage;
import com.bjss.pages.actions.ShippingPage;
import com.bjss.pages.actions.ShoppingCartSummaryPage;
import com.bjss.pages.actions.SigninPage;
import com.bjss.utilities.Utilities;

public class PurchaseItemTest {


	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void purchaseItemTest(Hashtable<String, String> data) {

		if (data.get("runmode").equalsIgnoreCase("N")) {

			throw new SkipException("Skipping the test as the Run mode is NO");
		}
		
		Page.initConfiguration();
		HomePage homePage = new HomePage();
		SigninPage signinPage = homePage.goToSigninPage();
		MyAccountPage myAccountPage = signinPage.doLogin(Constants.email, Constants.password);
		myAccountPage.goToHomePage();
		homePage.clickItemQuickView(0, true); //Select first item
		homePage.changeSizeQuickView(1);
		float firstItemPrice = homePage.clickAddToBasket();
		char firstItemSelectedSize = homePage.clickContinueShoppingButton();
		homePage.clickItemQuickView(1, false); //Select second item
		float secondItemPrice = homePage.clickAddToBasket();
		ShoppingCartSummaryPage shoppingCartSummaryPage = homePage.proceedToCheckoutButton();
		char assertfirstItemSelectedSize = shoppingCartSummaryPage.summaryPageFirstItemSize();
		float assertFirstItemPrice = shoppingCartSummaryPage.getPriceItem(0);
		float assertSecondItemPrice = shoppingCartSummaryPage.getPriceItem(1);
		float assertItemsTotalBeforeTax = shoppingCartSummaryPage.getItemsTotalBeforeTax(0);
		float assertTotalShippingCost = shoppingCartSummaryPage.getTotalShippingCost(0);
		float assertItemsTotalBeforeShipping = shoppingCartSummaryPage.getTotalBeforeShipping(0);
		
		float totalItemPrice = firstItemPrice + secondItemPrice;
		BigDecimal number = new BigDecimal(totalItemPrice);
		totalItemPrice = number.setScale(2, RoundingMode.DOWN).floatValue();
		
	
		System.out.println("firstItemPrice : " + firstItemPrice);
		System.out.println("firstItemSelectedSize : " + firstItemSelectedSize);
		System.out.println("secondItemPrice : " + secondItemPrice);
		System.out.println("assertfirstItemSelectedSize : " + assertfirstItemSelectedSize);
		System.out.println("assertFirstItemPrice : " + assertFirstItemPrice);
		System.out.println("assertSecondItemPrice : " + assertSecondItemPrice);
		System.out.println("assertItemsTotalBeforeTax : " + assertItemsTotalBeforeTax);
		System.out.println("assertTotalShippingCost : " + assertTotalShippingCost);
		System.out.println("assertItemsTotalBeforeShipping : " + assertItemsTotalBeforeShipping);
		System.out.println("totalItemPrice : " + totalItemPrice);
		
		Assert.assertEquals(firstItemSelectedSize, assertfirstItemSelectedSize, "The Selected size: " + firstItemSelectedSize + " is supposed to match the Cart size: " + assertfirstItemSelectedSize);
		Assert.assertEquals(firstItemPrice, assertFirstItemPrice, "The first item price:  " + firstItemPrice + " is supposed to match the first item price on the Cart page: " + assertFirstItemPrice);
		Assert.assertEquals(secondItemPrice, assertSecondItemPrice, "The second item price: " + secondItemPrice + " is supposed to match the second item price on the Cart page: " + assertSecondItemPrice);
		Assert.assertEquals(totalItemPrice, assertItemsTotalBeforeShipping, "The first and second item price totals: " + totalItemPrice + " is supposed to match the Cart total cost of the items before shipping and tax: " + assertItemsTotalBeforeShipping);
		Assert.assertEquals((assertItemsTotalBeforeShipping + assertTotalShippingCost), assertItemsTotalBeforeTax, "The total cost of the items before shipping added to the shipping cost: " + (assertItemsTotalBeforeShipping + assertTotalShippingCost) + " is supposed to match the total cost of the items before shipping added to the shipping cost added together: " + assertItemsTotalBeforeTax);

		AddressPage addressPage = shoppingCartSummaryPage.clickProceedThroughCheckout();
		ShippingPage shippingPage = addressPage.clickProceedThroughCheckout();
		shippingPage.selectAgreeToTerms();
		PaymentPage paymentPage = shippingPage.clickProceedThroughCheckout();
		paymentPage.clickPayByBankWire();
		OrderConfirmationPage orderConfirmationPage = paymentPage.clickConfirmOrder();
		orderConfirmationPage.getOrderReferenceAndDateAndWriteToFile();
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		if(Page.driver!=null){
		Page.quitBrowser();
		}
	}

}
