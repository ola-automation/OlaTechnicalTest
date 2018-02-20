package com.bjss.page.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePageLocators {
	
	@FindBy(css=".login")
	public WebElement signin_link;
	@FindBy(css=".quick-view")
	public List<WebElement> quickview_links;
	@FindBy(css=".product-container")
	public List<WebElement> item_containers;
	@FindBy(css=".exclusive")
	public List<WebElement> addToCartAndQuickViewVerification_button; //Element is a list to also be used in the switchToIframe to verify the ItemQuickView iframe
	@FindBy(css="#group_1")
	public WebElement size_dropdownbox;
	@FindBys({
		@FindBy(css="#group_1"),
		@FindBy(css = "option[selected='selected']")
	})
	public WebElement selectSize_dropdownvalue;
	@FindBy(css="span[class*='continue']>span")
	public WebElement continueShopping_button;
	@FindBy(css=".button-container>a>span")
	public WebElement proceedToCheckout_button;
	@FindBy(css="#our_price_display")
	public WebElement priceOfItem_label;
	@FindBy(css="#layer_cart_product_attributes")
	public WebElement itemAttributes_label;
	@FindBy(css=".homefeatured")
	public List<WebElement> featuredItems_link;
	
	

}
