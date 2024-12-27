Feature: Login functionality on OrangeHRM
  As a user
  I want to login to OrangeHRM
  So that I can access the employee management features


  Scenario: Login attempt with invalid credentials
    Given I navigate to the OrangeHRM login page
    When I enter invalid credentials "Admin" and "wrongPassword"
    And I click the login button
    Then I should see an error message "Invalid credentials"


  Scenario: Successful login with valid credentials
    Given I navigate to the OrangeHRM login page
    When I enter valid credentials "Admin" and "admin123"
    And I click the login button
    Then I should be redirected to the dashboard
  
  Scenario: Reset Password
    Given I logout from OrangeHRM
    When I click the forgot password link
    Then I should be taken to the reset password page