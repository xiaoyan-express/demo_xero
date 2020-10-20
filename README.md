Testing project for Xero application
====

In this project, the Xero pages are wrapped with POM ([Page Object Model](https://www.selenium.dev/documentation/en/guidelines_and_recommendations/page_object_models/)), and test cases are developed in two different ways:

 * TestNG suite
 * Cucumber features

Some of the pages are implemented with [Page Factory](https://www.toolsqa.com/selenium-webdriver/page-object-pattern-model-page-factory/).

# What is POM and why?
Starting an UI Automation in Selenium WebDriver is NOT a tough task. You just need to find elements, perform operations on it. The chief problem with script maintenance is that if 10 different scripts are using the same page element, with any change in that element, you need to change all 10 scripts. This is time consuming and error prone.

A better approach to script maintenance is to create a separate class file which would find web elements, fill them or verify them. This class can be reused in all the scripts using that element. In future, if there is a change in the web element, we need to make the change in just 1 class file and not 10 different scripts.

This approach is called Page Object Model(POM). It helps make the code more *readable*, *maintainable*, and *reusable*.
It is a design pattern, popularly used in test automation that creates Object Repository for web UI elements. The advantage of the model is that it reduces code duplication and improves test maintenance.

# What is Page Factory?
Page Factory in Selenium is an inbuilt Page Object Model concept for Selenium WebDriver but it is very optimized. It is used for initialization of Page objects or to instantiate the Page object itself. It is also used to initialize Page class elements without using "FindElement/s."

# What is listener?
Listener is defined as interface that modifies the default TestNG's behavior. As the name suggests Listeners "listen" to the event defined in the selenium script and behave accordingly. It is used in selenium by implementing Listeners Interface. It allows customizing TestNG reports or logs. There are many types of TestNG listeners available.
 
 * IAnnotationTransformer
 * IAnnotationTransformer2
 * IConfigurable
 * IConfigurationListener
 * IExecutionListener
 * IHookable
 * IInvokedMethodListener
 * IInvokedMethodListener2
 * IMethodInterceptor
 * IReporter
 * ISuiteListener
 * ITestListener

# References:
 * [Page Object Model (POM) & Page Factory: Selenium WebDriver Tutorial](https://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html)
 * https://www.guru99.com/listeners-selenium-webdriver.html
