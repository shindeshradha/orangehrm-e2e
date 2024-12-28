Feature: Login functionality on OrangeHRM
  As a user
  I want to reset the password
  So that I can login with my new password


  Scenario: Reset Password
    Given I navigate to the OrangeHRM login page to reset password
    When I click the forgot password link
    Then I should be taken to the reset password page

  Scenario: Email notification sent successfully
    Given I am on the password reset page
    When I enter a valid username "Admin"
    And I click the Reset Password button
    Then I should see the message "A password reset link has been sent successfully"

  Scenario Outline: Reset password email notifications for various users
    Given I am on the password reset page
    When I enter a valid username "<username>"
    And I click the Reset Password button
    Then I should see the message "A password reset link has been sent successfully"

    Examples:
      | username        |
      | Admin           |
      | TestUser123     |
      | Manager         |
      | support@xyz.com |
