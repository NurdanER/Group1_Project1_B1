Feature: Validate Buttons
  Background:
    Given user is on Docuport login page


  @smoke
  Scenario Outline: login Docuport
    When user enters "<username>" and "<password>" credentials
    And user clicks on "Receiveddocs" item
    And user validates "search button" is displayed
    And user validates "download button" is displayed
    And user validates "Received docs" is displayed
    And user clicks on "MyUploads" item
    Then user validates "MyUploads" is displayed

    Examples:
      | username                  | password |
      | b1g1_client@gmail.com     | Group1   |
      | b1g1_supervisor@gmail.com | Group1   |
      | b1g1_employee@gmail.com   | Group1   |
      | b1g1_advisor@gmail.com    | Group1   |





