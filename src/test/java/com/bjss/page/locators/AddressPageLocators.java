package com.bjss.page.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPageLocators {
	
	@FindBy(css="button[name='processAddress']")
	public WebElement proceedThroughCheckout_button;

}
