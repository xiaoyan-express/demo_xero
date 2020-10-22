package com.ta.demo_xero.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUlitiliesForXero extends TestBaseForXero {

	private WebDriver driver;

	public enum BrowserType {
		DEFAULT, // Chrome will be used
	    CHROME,
	    FIREFOX,
	}

	public WebDriver setupWebDriver(BrowserType browserType) {
		switch (browserType) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			this.driver = new FirefoxDriver();
			break;
		case CHROME:
			WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver();
			break;
		}
		return driver;
	}

	public void tearDownBrowser() {
		driver.quit();
	}

	public void explicitWaitFunc(WebElement ele, int iTime) {
		WebDriverWait wait1 = new WebDriverWait(driver, iTime);
		wait1.until(ExpectedConditions.visibilityOf(ele));
	}




}
