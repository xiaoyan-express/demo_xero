package com.ta.listener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ta.demo_xero.pages.LoginToXeroPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.ta.listener.ListenerTest.class)

public class XeroTest2 {
	private WebDriver driver;

	private enum BrowserType {
		DEFAULT, // Chrome will be used
	    CHROME,
	    FIREFOX,
	}

	private void setupWebDriver(BrowserType browserType) {
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
	}

	@BeforeMethod
	public void setup() {
		setupWebDriver(BrowserType.FIREFOX);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void xeroLoginPageTest() throws Exception {
		LoginToXeroPage page = new LoginToXeroPage(driver);
		page.loginToWebSite("xyzxiaoyan@163.com", "xyz12345");
		page.verifyLoginResult();
	}

	//@Test
	public void xeroLoginPageTestFailed() throws Exception {
		LoginToXeroPage page = new LoginToXeroPage(driver);
		page.loginToWebSite("xyzxiaoyan@163.com", "wrong password");
		page.verifyLoginResult();
	}
}
