Feature: New User Creation in actiTime

  Scenario Outline: Admin creates a new user account
    Given the admin is logged in to the HR management system with "<username>" and "<password>"
    When the admin navigates to the Users page
    And the admin clicks the button to create a new user
    And the admin fills in the mandatory fields for a new user with "<firstName>", "<lastName>", and "<email>"
    And the admin submits the new user creation form
    Then a new user account should be created successfully

    Examples:
      | username | password  | firstName | lastName | email               |
      | yasith@ahlab.org    | admin123 | First       | UserSecond     | newuser@example.com |

