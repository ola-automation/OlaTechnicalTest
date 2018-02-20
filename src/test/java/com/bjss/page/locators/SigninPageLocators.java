package com.bjss.page.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPageLocators {
	
	@FindBy(css="#email")
	public WebElement email_txtfield;
	@FindBy(css="#passwd")
	public WebElement password_txtfield;
	@FindBy(css="#SubmitLogin")
	public WebElement signin_btn;

}
