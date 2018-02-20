package com.bjss.pages.actions;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.bjss.base.Page;
import com.bjss.page.locators.OrderHistoryAndDetailsLocators;

public class OrderHistoryAndDetailsPage extends Page{
	
	public OrderHistoryAndDetailsLocators orderHistoryAndDetailsPage;
	Actions action = new Actions(driver);
	public OrderHistoryAndDetailsPage() {
		
		this.orderHistoryAndDetailsPage = new OrderHistoryAndDetailsLocators();
		PageFactory.initElements(driver, this.orderHistoryAndDetailsPage);
	}
	
	public String getOrderDate() {
		
		String orderDate = orderHistoryAndDetailsPage.orderHistoryDates_texts.get(0).getText();
		System.out.println("The order date on the Order details page is: " + orderDate);
		return orderDate;
	}
	
	public String getOrderReference() {
		
		String orderReference = orderHistoryAndDetailsPage.orders_links.get(0).getText();
		System.out.println("The order reference on the Order details page is: " + orderReference); 
		return orderReference;
	}
	
	public void selectFirstOrderReference() {
		
		click(orderHistoryAndDetailsPage.ordersDetails_buttons.get(0)); //bptesting
		waitForElementToBeClickable(orderHistoryAndDetailsPage.postMessage_textbox, 5);
		scrollToElement(orderHistoryAndDetailsPage.sendMessage_button, 5);
		waitForElementToBeClickable(orderHistoryAndDetailsPage.postMessage_textbox, 5);
	}
	
	public boolean scrollToElement(WebElement element, int seconds) {

		if(waitForElementToBeClickable(element, seconds)) {
			return true;
		}else {
			waitForSecondsWithoutThread(1);
			action.sendKeys(Keys.PAGE_DOWN).perform(); 
			return false;
		}
	}
	
	public String leaveMessage() {
		
		String timeMessage = new SimpleDateFormat("H:M:S").format(new Date());
		String message = "The Hour, minutes and seconds are right now are: " + timeMessage + "!!";
		waitForElementToBeClickable(orderHistoryAndDetailsPage.selectOrder_dropdownlist.get(0), 5);
		type(orderHistoryAndDetailsPage.postMessage_textbox, message);
		click(orderHistoryAndDetailsPage.selectOrder_dropdownlist.get(0));
		click(orderHistoryAndDetailsPage.dropDownList_options.get(1));
		click(orderHistoryAndDetailsPage.sendMessage_button);
		waitForSecondsWithoutThread(5); //bptesting
		return message;
	}
	
	public String getMessageSent(){
		
		int index = orderHistoryAndDetailsPage.messageSentVerification_text.size()-1; //its the last index
		waitForElementToDisplay(orderHistoryAndDetailsPage.messageSentVerification_text.get(index), 5);
		scrollElementIntoView(orderHistoryAndDetailsPage.messageSentVerification_text.get(index));
		String messageSent = orderHistoryAndDetailsPage.messageSentVerification_text.get(index).getText();
		System.out.println("The message sent is: " + messageSent);
		return messageSent;
	}
	


}
