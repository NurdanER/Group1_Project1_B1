Feature: Validate Leads in Advisor
  Background:
    Given user is on Docuport login page

  @smoke
  Scenario: User should be able login as advisor and validate Rows Per Page
    When user enters credentials for advisor role
    And user clicks on "Leads" item
    And user validates that Rows Per Page shows by default 10 on a "Leads" page
    And user changes Rows Per Page to 5
    And user validates that Rows per page shows 5 on a "Leads" page
    And user clicks on "Users" item
    And user validates that Rows Per Page shows by default 10 on a "Users" page
    And user changes Rows Per Page to 5
    Then user validates that Rows per page shows 5 on a "Users" page