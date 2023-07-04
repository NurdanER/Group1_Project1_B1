Feature: Passing multiple parameters to the same step

@nsu
  Scenario: Searching multiple items
    Given user is on Google search page
    Then user searches the following item

    |loop academy|
    |java        |
    |selenium    |
    |cucumber bdd|
    |sql         |

#Data Table is related with single step but multiple data
