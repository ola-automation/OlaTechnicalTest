package com.bjss.pages.actions;

import org.openqa.selenium.support.PageFactory;

import com.bjss.base.Page;
import com.bjss.page.locators.ShippingPageLocators;

public class ShippingPage extends Page{
	
	public ShippingPageLocators shippingPage;
	
	public ShippingPage() {
		
		this.shippingPage = new ShippingPageLocators();
		PageFactory.initElements(driver, shippingPage);
	}
	
public PaymentPage  clickProceedThroughCheckout() {
		
		scrollElementIntoView(shippingPage.proceedThroughCheckout_button);
		click(shippingPage.proceedThroughCheckout_button);
		return new PaymentPage();
	}

public void selectAgreeToTerms() {
	
	click(shippingPage.agreeToTerms_checkbox);
	
}

}
