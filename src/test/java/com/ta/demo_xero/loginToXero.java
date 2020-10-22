package com.ta.demo_xero;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ta.demo_xero.pages.LoginToXeroPage;
import com.ta.demo_xero.utilities.TestBaseForXero;

@Listeners(com.ta.demo_xero.ListenerTest.class)

public class loginToXero extends TestBaseForXero{

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
