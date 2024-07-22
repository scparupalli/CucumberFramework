Feature: Salesforce Login Scenarios

  Scenario: Verify Salesforce application page is displayed and Login Error Message
    Given I open the Salesforce login page
    Then I should see the Salesforce application page
    When I enter the username as "<username>"
    And I clear the password field
    And I click on the Login to Salesforce button
    Then I should see the error message "Please enter your password."

  Scenario: Successful login
    Given I open the Salesforce login page
    Then I should see the Salesforce application page
    When I enter the username as "<username>"
    And I enter the password as "<password>"
    And I click on the Login to Salesforce button
    Then I should see the Salesforce home page

  Scenario: Remember username after logout
    Given I open the Salesforce login page
    Then I should see the Salesforce application page
    When I enter the username as "<username>"
    And I enter the password as "<password>"
    And I select the remember username checkbox
    And I click on the Login to Salesforce button
    Then I should see the Salesforce home page
    When I click on the user menu dropdown
    And I select the logout link
    And the username field should be populated with "<username>"
    And the remember username checkbox should be checked

  Scenario: Forgot password
    Given I open the Salesforce login page
    When I click on the Forgot Password link
    Then I should see the Salesforce forgot password page
    When I enter "<username>" in the forgot password username field
    And I click on the Continue button
    Then I should see the password reset message
    And an email should be sent to the email associated with "<username>"

  Scenario: Invalid login
    Given I open the Salesforce login page
    When I enter "<invalidusername>" in the username field
    And I enter "<invalidpassword>" in the password field
    And I click on the Login to Salesforce button
    Then I should see the error message "Please check your username and password. If you still can't log in, contact your Salesforce administrator."
