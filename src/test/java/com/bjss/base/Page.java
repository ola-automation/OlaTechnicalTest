package com.bjss.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bjss.utilities.ExcelReader;
import com.bjss.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Page {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static com.bjss.utilities.ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "//src//test//resources//excel//testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;

	public static void initConfiguration() {

		if (Constants.browser.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "//src//test//resources//executables//gecko");
			driver = new FirefoxDriver();
			log.debug("Firefox Launched!!!");
		} else if (Constants.browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");

			driver = new ChromeDriver(options);
			log.debug("Launching Chrome");
		} else if (Constants.browser.equals("ie")) {
			/*
			 * Disabled because OS is not windows - directory should be dynamic set to
			 * change depending on OS
			 */

			// System.setProperty("webdriver.ie.driver",
			// System.getProperty("user.dir") +
			// "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			//
			// driver = new InternetExplorerDriver();
			// log.debug("Launching IE");
		}

		driver.get(Constants.testsiteurl);
		driver.manage().window().maximize();

	}

	public static Boolean switchToIframe(List<WebElement> elements) {
		
		int size = driver.findElements(By.tagName("iframe")).size();
		for (int i = 0; i <= size; i++) {
			driver.switchTo().frame(i);
			int total = elements.size();
			if (total > 0) {
				return true;
			}
			driver.switchTo().defaultContent();
		}
		log.debug("Failed to switch to frame with element: " + elements);
		test.log(LogStatus.INFO, "Failed to switch to frame with element: " + elements);
		return false;
	}
	
	public static void selectDropDownBoxByIndex(WebElement element, int index) {
		
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	//Method is supposed to not find the ID which ensures that it waits for specified time without using Thread.sleep
	public static Boolean waitForSecondsWithoutThread(int waitTime) {

		try {
			return new WebDriverWait(driver, waitTime).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(final WebDriver d) {
					return d.findElement(By.id("iWantYouToWait")).isDisplayed();
				}
			});
		} catch (Exception e) {
			log.debug("Waited for  : " + waitTime + " seconds");
			test.log(LogStatus.INFO, "Waited for  : " + waitTime + " seconds");
			return true;
		}
	}

//	public static Boolean waitForElementToDisplay(final WebElement element, int waitTime) {
//
//		try {
//			return new WebDriverWait(driver, waitTime).until(new ExpectedCondition<Boolean>() {
//				public Boolean apply(final WebDriver d) {
//					log.debug("Finding element : " + element);
//					test.log(LogStatus.INFO, "Finding : " + element);
//					return element.isDisplayed();
//				}
//			});
//		} catch (Exception e) {
//			log.debug("Failed to find element : " + element);
//			test.log(LogStatus.INFO, "Failed to find element : " + element);
//			return false;
//		}
//	}
	
	public static Boolean waitForElementToDisplay(final WebElement element, int seconds) {

		wait = new WebDriverWait(driver, seconds);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			log.debug("Failed to find element : " + element);
			test.log(LogStatus.INFO, "Failed to find element : " + element);
			return false;
		}
	}
	
	public static Boolean waitForElementToBeClickable(final WebElement element, int seconds) {
		wait = new WebDriverWait(driver, seconds);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			log.debug("Failed to find element : " + element);
			test.log(LogStatus.INFO, "Failed to find element : " + element);
			return false;
		}
	}
	
	public static void scrollElementIntoView(WebElement element) {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void click(WebElement element) {

		waitForElementToDisplay(element, Constants.waitTime);
		element.click();
		log.debug("Clicking on an Element : " + element);
		test.log(LogStatus.INFO, "Clicking on : " + element);
	}
	
	public static void type(WebElement element, String value) {

		waitForElementToDisplay(element, Constants.waitTime);
		element.sendKeys(value);
		log.debug("Typing in an Element : " + element + " entered value as : " + value);
		test.log(LogStatus.INFO, "Typing in : " + element + " entered value as " + value);

	}

	public static void quitBrowser() {
		driver.quit();
	}

}