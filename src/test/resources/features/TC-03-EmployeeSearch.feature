Feature: Employee Search functionality on OrangeHRM
  As an admin user
  I want to be able to search for employee details
  So that I can modify them

  Background:
    Given I login to OrangeHRM as an admin user

  Scenario: Employee Search
    Given I navigate to the PIM module
    When I search for an employee with "<field>" of "<value>"
    Then the system should report "<message>"

    Examples:
      | field         | value  | message          |
      | Employee Id   |  12345 | (1) Record Found |
      | Employee Id   |  12346 | (1) Record Found |
      | Employee Id   | dummy  | No Records Found |
      | Employee Name | Orange | (1) Record Found |
      | Employee Name | dummy  | No Records Found |
