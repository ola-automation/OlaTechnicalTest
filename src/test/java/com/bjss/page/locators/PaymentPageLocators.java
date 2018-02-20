package com.bjss.page.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPageLocators {

	@FindBy(css=".bankwire")
	public WebElement payByBankWire_link;
	
	@FindBy(css="button[class*='button-medium']")
	public WebElement confirmOrder_button;
	
	
	
}
