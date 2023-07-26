Feature: Docuport Login Logout Feature

  Background: will run for each scenario first
    Given user is on Docuport login page


@smoke
  Scenario: Login as a client map practice

 When user enters credentials
 | username | b1g1_client@gmail.com |
 | password | Group1                |
 Then user should see the home page for client