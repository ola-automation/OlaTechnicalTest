package com.bjss.page.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryAndDetailsLocators {
	
	@FindBy(css="td[class*='footable-first-column']>a")
	public List<WebElement> orders_links;
	@FindBy(css=".history_date.bold")
	public List<WebElement> orderHistoryDates_texts;
//	@FindBy(css="a[title^='Proceed']")
//	public WebElement sendMessage_button;
//	@FindBy(css=".button-container>a:nth-child(2)")
//	public List<WebElement> sendMessage_button;
	@FindBy(xpath="//*[@id='sendOrderMessage']/div/button")
	public WebElement sendMessage_button;
	@FindBy(css="select[name='id_product']")
	public List<WebElement> selectOrder_dropdownlist;
	@FindBy(css="select[name='id_product']>option")
	public List<WebElement> dropDownList_options;
	@FindBy(css="textarea[name='msgText']")
	public WebElement postMessage_textbox;
	@FindBy(css="td[class^='history_detail']>a:nth-child(1)")
	public List<WebElement> ordersDetails_buttons;
	@FindBy(css=".first_item.item>td")
	public List<WebElement> messageSentVerification_text;
}
