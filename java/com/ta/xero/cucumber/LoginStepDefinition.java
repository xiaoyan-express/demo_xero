package com.ta.xero.cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinition {
	private final static int TIMEOUT_IN_SECONDS = 40;

	WebDriver driver;

	By emailFieldElement = By.id("xl-form-email");

	By passwordFieldElement = By.id("xl-form-password");

	By loginButtonElement = By.id("xl-form-submit");

	By dashboardElement = By.xpath("//a[@name='navigation-menu/dashboard']");

	private String loginUrlString = "https://login.xero.com/identity/user/login/";

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

	@Given("^I launch the browser$")
	public void launchBrowser() throws Throwable {
		setupWebDriver(BrowserType.CHROME);

		driver.manage().timeouts().implicitlyWait(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
	}

	@And("^I set timeout to \"([^\"]*)\"$")
	public void SetScriptTimeout(int timeoutInSeconds) {
		driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(timeoutInSeconds, TimeUnit.SECONDS);
	}

	@When("^I reach the login page$")
	public void loginPage() throws Throwable {
		driver.get(loginUrlString);
		driver.manage().window().maximize();
	}

	@And("^I type \"([^\"]*)\" and \"([^\"]*)\"$")
	public void typeUsernameAndPassword(String username, String password) throws Throwable {
		driver.findElement(emailFieldElement).click();
		driver.findElement(emailFieldElement).clear();
		driver.findElement(emailFieldElement).sendKeys(username);
		driver.findElement(passwordFieldElement).clear();
		driver.findElement(passwordFieldElement).sendKeys(password);

	}

	@And("^I click login button$")
	public void clickLoginButton() throws Throwable {
		driver.findElement(loginButtonElement).click();
	}

	@Then("^I validate login result$")
	public void validateLoginResult() throws Throwable {

	}

	@And("^I verify the dashboard element$")
	public void verifyDashboardElem() throws Throwable {
		WebElement dashboard = driver.findElement(dashboardElement);
		Assert.assertEquals(dashboard.isDisplayed(), true);
	}

	@After
	public void close() throws Throwable {
		driver.close();
	    driver.quit();
	}
}
