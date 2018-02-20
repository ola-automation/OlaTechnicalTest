package com.bjss.pages.actions;

import org.openqa.selenium.support.PageFactory;

import com.bjss.base.Page;
import com.bjss.page.locators.PaymentPageLocators;

public class PaymentPage extends Page{
	
	public PaymentPageLocators paymentPage;
	
	public PaymentPage() {
		
		this.paymentPage = new PaymentPageLocators();
		PageFactory.initElements(driver, paymentPage);
	}
	
public void clickPayByBankWire() {
		
		scrollElementIntoView(paymentPage.payByBankWire_link);
		click(paymentPage.payByBankWire_link);
	}

public OrderConfirmationPage clickConfirmOrder() {
	
	scrollElementIntoView(paymentPage.confirmOrder_button);
	click(paymentPage.confirmOrder_button);
	return new OrderConfirmationPage();
}

}
