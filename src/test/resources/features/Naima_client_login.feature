Feature: Docuport Login Logout Feature

  Background: will run for each scenario first
    Given user is on Docuport login page


  @smoke
  Scenario: Login as a client
    Given user is on Docuport login page
    When user enters credentials for client role
    Then user should see the home page for client
