package com.bjss.page.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPageLocators {

	@FindBy(css="button[name='processCarrier']")
	public WebElement proceedThroughCheckout_button;
	
	@FindBy(css="#cgv")
	public WebElement agreeToTerms_checkbox;
	
}
