package com.ta.xero.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource/features/xero-login.feature", glue = {"com.ta.xero.cucumber"})
public class LoginTestRunner {

}
