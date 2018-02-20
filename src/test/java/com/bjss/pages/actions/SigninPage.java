package com.bjss.pages.actions;

import org.openqa.selenium.support.PageFactory;

import com.bjss.base.Page;
import com.bjss.page.locators.SigninPageLocators;

public class SigninPage extends Page {
	
	public SigninPageLocators signinPage;
	
	public SigninPage() {
		
		this.signinPage = new SigninPageLocators();
		PageFactory.initElements(driver, this.signinPage);
	}
	
	public MyAccountPage doLogin(String emailAddress, String password) {
		
		type(signinPage.email_txtfield, emailAddress);
		type(signinPage.password_txtfield, password);
		click(signinPage.signin_btn);
		
		return new MyAccountPage();
	}

}
