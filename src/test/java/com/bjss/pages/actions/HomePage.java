package com.bjss.pages.actions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.bjss.base.Page;
import com.bjss.page.locators.HomePageLocators;

public class HomePage extends Page{
	
	public HomePageLocators homePage;
	
	public HomePage() {
		
		this.homePage = new HomePageLocators();
		PageFactory.initElements(driver, this.homePage);		
	}
	
	public SigninPage goToSigninPage() {
		
		click(homePage.signin_link);
		return new SigninPage();
	}
	
	public void clickItemQuickView(int itemNumber, boolean scrollDown) {
		
		Actions action = new Actions(driver);
		//ScrollDown only needed to select first item
		if(scrollDown) {
			//action.sendKeys(Keys.PAGE_DOWN).perform(); 
			scrollElementIntoView(homePage.item_containers.get(itemNumber));
		}
		//click on the first item
		waitForElementToDisplay(homePage.item_containers.get(itemNumber), 10);
		action.moveToElement(homePage.item_containers.get(itemNumber)).moveToElement(homePage.quickview_links.get(itemNumber)).click().build().perform();
		Page.waitForSecondsWithoutThread(2); //NOT using Thread.sleep 
	}
	
	public String changeSizeQuickView(int index) {
		
		switchToIframe(homePage.addToCartAndQuickViewVerification_button);
		String sizeBeforeChange = homePage.selectSize_dropdownvalue.getText();
		selectDropDownBoxByIndex(homePage.size_dropdownbox, index);
		driver.switchTo().defaultContent();
		return sizeBeforeChange;
	}
	
	public float clickAddToBasket(){
		
		switchToIframe(homePage.addToCartAndQuickViewVerification_button);
		float priceOfItem = Float.parseFloat(homePage.priceOfItem_label.getText().substring(1));
		click(homePage.addToCartAndQuickViewVerification_button.get(0));
		driver.switchTo().defaultContent();
		Page.waitForSecondsWithoutThread(2); //NOT using Thread.sleep 
		return priceOfItem;
	}
	
	public char clickContinueShoppingButton() {
		
		String selectedSizeString = homePage.itemAttributes_label.getText();
		char selectedSize = selectedSizeString.charAt(selectedSizeString.length()-1);	
		click(homePage.continueShopping_button);
		Page.waitForSecondsWithoutThread(2); //NOT using Thread.sleep 
		return selectedSize;
	}
	
	public ShoppingCartSummaryPage proceedToCheckoutButton() {
	
		click(homePage.proceedToCheckout_button);
		return new ShoppingCartSummaryPage();
	}

	public String getIntentionalFailText() {
		
		String correctText = homePage.featuredItems_link.get(0).getText();
		System.out.println("The correct text of the featured heading is: " + correctText);
		return correctText;
	}
	
	
	

}























