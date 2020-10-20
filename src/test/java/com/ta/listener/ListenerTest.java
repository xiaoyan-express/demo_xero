package com.ta.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener{

	// When Test case get Started, this method is called.
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + "test case started");
	}

    // When Test case get passed, this method is called.
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase passed is: " + result.getName());

	}

	// When Test case get failed, this method is called
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is: " + result.getName());
	}

	// When Test case get Skipped, this method is called.
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase skipped is: " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
