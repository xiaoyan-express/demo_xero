# Author: xyz
# Keywords Summary : login page for xero
@tag
Feature: Login feature for Xero

  @tag1
  Scenario: Login
    Given I launch the browser
    When I reach the login page
    And I type "xyzxiaoyan@163.com" and "xyz12345"
    And I click login button
    Then I validate login result
    And I verify the dashboard element
  
  @Failed
  Scenario: Login Failed
    Given I launch the browser
    And I set timeout to "5"
    When I reach the login page
    And I type "xyzxiaoyan@163.com" and "incorrect-password"
    And I click login button
    Then I validate login result
    And I verify the dashboard element
  