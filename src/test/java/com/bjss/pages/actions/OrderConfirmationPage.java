package com.bjss.pages.actions;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.support.PageFactory;

import com.bjss.base.Page;
import com.bjss.page.locators.OrderConfirmationLocators;

public class OrderConfirmationPage extends Page{
	
	public OrderConfirmationLocators orderConfirmation;
	
	public OrderConfirmationPage() {
		
		this.orderConfirmation = new OrderConfirmationLocators();
		PageFactory.initElements(driver, orderConfirmation);
	}
	
public String getOrderReferenceAndDateAndWriteToFile() {
		
		scrollElementIntoView(orderConfirmation.confirmationDetails_text);
		String confirmationDetails = orderConfirmation.confirmationDetails_text.getText();
		String[] confirmationDetailsArray = confirmationDetails.split("\\s+");
		int index = 0;
		for(int i = 0; i < confirmationDetailsArray.length-1; i++) {
			System.out.println(i);
			if(confirmationDetailsArray[i].equalsIgnoreCase("reference")) {
			index = i;
			break;
			}
		}
		String orderReference = confirmationDetailsArray[index+1];
		System.out.println("Order Reference is: " + orderReference);
	    
	    Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("MM/dd/yyyy");
	    String orderDate = ft.format(dNow);
	    System.out.println("Order date is: " + orderDate);
		
		excel.setCellData("ReviewOrderAddCommentTest", "orderReference", 2, orderReference);
		excel.setCellData("ReviewOrderAddCommentTest", "orderDate", 2, orderDate);
		return confirmationDetails;
	}

}
