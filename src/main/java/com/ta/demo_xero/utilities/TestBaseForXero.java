package com.ta.demo_xero.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.ta.demo_xero.utilities.BrowserUlitiliesForXero.BrowserType;

public class TestBaseForXero {

	public static BrowserUlitiliesForXero oBrowserUlitiliesForXero = new BrowserUlitiliesForXero();
	public WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest loggerExtentTest;
	String pathString = System.getProperty("user.dir") + "/ExtentReport/reportBrowser.html";

	@BeforeSuite
	public void launchingBrowser() throws Exception {
		reports = new ExtentReports(pathString);
		driver = oBrowserUlitiliesForXero.setupWebDriver(BrowserType.CHROME);
	}

	@AfterSuite
	public void closingTest() {
		oBrowserUlitiliesForXero.tearDownBrowser();
		reports.flush();
	}

}
