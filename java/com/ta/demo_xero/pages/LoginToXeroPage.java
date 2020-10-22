package com.ta.demo_xero.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginToXeroPage {
	private final static int TIMEOUT_IN_SECONDS = 40;

	WebDriver driver;

	By emailFieldElement = By.id("xl-form-email");

	By passwordFieldElement = By.id("xl-form-password");

	By loginButtonElement = By.id("xl-form-submit");

	By dashboardElement = By.xpath("//a[@name='navigation-menu/dashboard']");

	private String loginUrlString = "https://login.xero.com/identity/user/login/";

	public LoginToXeroPage(WebDriver driver) {
		this.driver = driver;

		driver.manage().timeouts().implicitlyWait(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
	}

	public void loginToWebSite(String username, String password) throws Exception {
		driver.get(loginUrlString);
		driver.manage().window().maximize();

		driver.findElement(emailFieldElement).click();
		driver.findElement(emailFieldElement).clear();
		driver.findElement(emailFieldElement).sendKeys(username);
		driver.findElement(passwordFieldElement).clear();
		driver.findElement(passwordFieldElement).sendKeys(password);
		driver.findElement(loginButtonElement).click();
	}

	public void verifyLoginResult() {
		WebElement dashboard = driver.findElement(dashboardElement);
		Assert.assertEquals(dashboard.isDisplayed(), true);
	}
}
