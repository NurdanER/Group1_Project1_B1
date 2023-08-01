Feature: As a data consumer, I want the department information stored in postgres DB correctly in department table.

  Background:
    Given Establish the database connection

  @smoke
  Scenario: verify database departments table columns
    When Execute query to get all column for "departments"
    Then Verify the below column sare listed in result for

      | tax                  |
      | bookkeeping          |
      | payroll              |
      | consultancy-services |

