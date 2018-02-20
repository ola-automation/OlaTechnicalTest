package com.bjss.pages.actions;

import org.openqa.selenium.support.PageFactory;

import com.bjss.base.Page;
import com.bjss.page.locators.MyAccountPageLocators;

public class MyAccountPage extends Page{
	
	public MyAccountPageLocators myAccountPage;
	
	public MyAccountPage() {
		
		this.myAccountPage = new MyAccountPageLocators();
		PageFactory.initElements(driver, this.myAccountPage);
	}
	
	public HomePage goToHomePage() {
		
		click(myAccountPage.homePage_link);
		return new HomePage();		
	}
	
	public OrderHistoryAndDetailsPage goToOrderHistoryAndDetailsPage() {
		
		scrollElementIntoView(myAccountPage.myAccounyLinksList_Links.get(0));
		click(myAccountPage.myAccounyLinksList_Links.get(0));
		return new OrderHistoryAndDetailsPage();
	}
	
	
	
	

}
