Feature: Validation of creating new client
@sh
  Scenario: Creating and logging in as a new client
    Given user is on Docuport login page
    When user enters credentials for advisor role
    And user clicks Client button and creates new client
    And user validates that new client created
    And user logs out as an advisor
    Then user logs in as a new client