package com.ta.demo_xero;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ta.demo_xero.pages.LoginToXeroPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XeroTest {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
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

	@Test
	public void xeroLoginPageTestFailed() throws Exception {
		LoginToXeroPage page = new LoginToXeroPage(driver);
		page.loginToWebSite("xyzxiaoyan@163.com", "wrong password");
		page.verifyLoginResult();
	}
}
