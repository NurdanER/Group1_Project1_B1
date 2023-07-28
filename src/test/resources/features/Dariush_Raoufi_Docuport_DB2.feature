Feature: Department Information Storage in PostgreSQL DB

  As a data consumer,
  I want the department information stored in the PostgreSQL database correctly in the department table.

  Background:
    Given Establish the database connection

  @smoke
  Scenario: Verify "departments" table columns
    When I execute the query to get all columns for the "document.users" table
    Then Verify the below columns are listed in result for id

      | 1    |
      | 2    |
      | 3    |
      | 4    |
      | 5    |
      | ...  |
      | 567  |