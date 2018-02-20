package com.bjss.pages.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.bjss.base.Page;
import com.bjss.page.locators.ShoppingCartSummaryLocators;

public class ShoppingCartSummaryPage extends Page {

	public ShoppingCartSummaryLocators shoppingCartSummaryPage;

	public ShoppingCartSummaryPage() {

		this.shoppingCartSummaryPage = new ShoppingCartSummaryLocators();
		PageFactory.initElements(driver, shoppingCartSummaryPage);
	}

	public char summaryPageFirstItemSize() {

		waitForElementToDisplay(shoppingCartSummaryPage.itemDescription_label.get(1), 10);
		String summaryPageFirstItemSizeString = shoppingCartSummaryPage.itemDescription_label.get(1).getText();
		char summaryPageFirstItemSize = summaryPageFirstItemSizeString
				.charAt(summaryPageFirstItemSizeString.length() - 1);
		return summaryPageFirstItemSize;
	}

	public float getPrice(WebElement element, int index) {

		scrollElementIntoView(element);
		System.out.println(element.getText().substring(1));
		float priceOfItem = Float.parseFloat(element.getText().substring(1));
		return priceOfItem;
	}

	public float getPriceItem(int index) {

		return getPrice(shoppingCartSummaryPage.priceItem_text.get(index), index);
	}
	
	public float getItemsTotalBeforeTax(int index) {

		return getPrice(shoppingCartSummaryPage.totalPriceBeforeTax_text.get(index), index);
	}
	
	public float getTotalShippingCost(int index) {

		return getPrice(shoppingCartSummaryPage.totalShipping_text.get(index), index);
	}
	
	public float getTotalBeforeShipping(int index) {

		return getPrice(shoppingCartSummaryPage.totalBeforShipping.get(index), index);
	}
	
	public AddressPage clickProceedThroughCheckout() {
		
		scrollElementIntoView(shoppingCartSummaryPage.proceedThroughCheckout_button);
		click(shoppingCartSummaryPage.proceedThroughCheckout_button);
		return new AddressPage();
	}

}
