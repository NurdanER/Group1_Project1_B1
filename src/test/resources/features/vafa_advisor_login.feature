Feature: Docuport Login Feature

  Background: Will run for each scenario first
    Given user is on Docuport login page

@smoke
  Scenario: Login as a advisor
    Given user is on Docuport login page
    When user enters credentials for advisor role
    Then user should see the home page for advisor


