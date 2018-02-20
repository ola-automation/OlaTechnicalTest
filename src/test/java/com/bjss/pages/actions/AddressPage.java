package com.bjss.pages.actions;

import org.openqa.selenium.support.PageFactory;

import com.bjss.base.Page;
import com.bjss.page.locators.AddressPageLocators;

public class AddressPage extends Page{
	
	public AddressPageLocators addressPage;
	
	public AddressPage() {
		
		this.addressPage = new AddressPageLocators();
		PageFactory.initElements(driver, addressPage);
	}
	
public ShippingPage clickProceedThroughCheckout() {
		
		scrollElementIntoView(addressPage.proceedThroughCheckout_button);
		click(addressPage.proceedThroughCheckout_button);
		return new ShippingPage();
	}

}
