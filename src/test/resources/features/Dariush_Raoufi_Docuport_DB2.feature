Feature: Verify "departments" table columns

  Background:
    Given Establish the database connection

  @smoke
  Scenario: Verify "departments" table columns
    When I execute the query to get all columns for the "document.users" where first name "Batch1"
    Then Verify the below columns are listed in result for id

      | 42 |
      | 43 |
      | 44 |
      | 45 |
      | 46 |
      | 47 |
      | 48 |
      | 49 |
      | 50 |
      | 51 |
      | 52 |
      | 53 |
      | 54 |
