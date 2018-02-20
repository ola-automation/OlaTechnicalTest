package com.bjss.page.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPageLocators {
	
	@FindBy(css="#header_logo>a")
	public WebElement homePage_link;
	
	@FindBy(css=".myaccount-link-list>li>a")
	public List<WebElement> myAccounyLinksList_Links;

}
