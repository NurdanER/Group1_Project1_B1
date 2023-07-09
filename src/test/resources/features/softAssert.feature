Feature: sample feature to demo soft assertions

  @soft
  Scenario: Sample scenarios for soft assertions
    Given user is on Docuport login page
    When user enters credentials
      | username | b1g1_client@gmail.com |
      | password | Group1                |
    And user validates choose account pop up is visible
    And user chooses account from drop down



    #with help of soft assertions, I can continue testing even if the step was failed..