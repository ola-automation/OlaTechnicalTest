package com.bjss.page.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ShoppingCartSummaryLocators {

	@FindBys({
		@FindBy(css="tr[class*='first_item']>.cart_description"),
		@FindBy(css = "a")
	})
	public List<WebElement> itemDescription_label;
	@FindBy(css="span[id*='total_product_price']")
	public List<WebElement> priceItem_text;
	@FindBy(css="#total_price_without_tax")
	public List<WebElement> totalPriceBeforeTax_text;
	@FindBy(css="#total_shipping")
	public List<WebElement> totalShipping_text; 
	@FindBy(css="#total_product")
	public List<WebElement> totalBeforShipping; 
	@FindBy(css="a[class*='standard-checkout']")
	public WebElement proceedThroughCheckout_button; 
}
