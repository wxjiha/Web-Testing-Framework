Feature: Signup

  In order to be able to make purchases on the website
  As a new user
  I want to be able to create an account successfully

  @Happy
  Scenario: Signup with valid username and valid password
    Given I am on the home page
    And I have clicked on the signup button
    When I enter a new username "KrishPriya"
    And I enter a password "Kumari123"
    And I click the signup confirmation button
    Then I should see a popup message saying "Sign up successful."

  @Sad
  Scenario Outline: Signup with invalid or missing information
    Given I am on the home page
    And I have clicked on the signup button
    When I enter a username "<users>"
    And I enter a password "<password>"
    And I click the signup confirmation button
    Then I should see an alert message saying "<message>"

    Examples:
      | users        | password | message                                |
      | standard_use | Pass123  | This user already exist.               |
      | new_user123  |          | Please fill out Username and Password. |
      |              | Pass123  | Please fill out Username and Password. |
      |              |          |                                        |

