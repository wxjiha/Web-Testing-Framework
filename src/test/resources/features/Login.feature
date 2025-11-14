Feature: Login

  In order to be able to buy items
  As a registered user of the Sauce Labs website
  I want to be able to sign in to my account

  @Happy
  Scenario: Login with valid username and valid password
    Given  I am on the home page for logging in
    And have clicked on the login button
    And  I entered the username "goodtest"
    And I entered the password  "password"
    When I click the login button
    Then I should return to the home page
    And my username should be visible on the navbar


  @Sad
  Scenario: Login with an invalid username and valid password
    Given  I am on the home page for logging in
    And have clicked on the login button
    And  I entered the username "invalidusername"
    And I entered the password  "password"
    When I click the login button
    Then I should see a pop up saying user does not exist


  @Sad
  Scenario: Login with an valid username and invalid password
    Given  I am on the home page for logging in
    And have clicked on the login button
    And  I entered the username "invalid"
    And I entered the password  "password"
    When I click the login button
    Then I should see a pop up saying wrong password


  @Sad
  Scenario: Login with an empty username field and a valid password
    Given  I am on the home page for logging in
    And have clicked on the login button
    And  I leave the username field blank
    And I entered the password  "password"
    When I click the login button
    Then I should see a pop up telling me to fill out Username and password

  @Sad
  Scenario: Login with an valid username and empty password field
    Given  I am on the home page for logging in
    And have clicked on the login button
    And  I entered the username "username"
    And I leave the password field blank
    When I click the login button
    Then I should see a pop up telling me to fill out Username and password


  @Happy
  Scenario: Logout
    Given  I am logged in already
    When I click the log out button
    Then I should return to the home page
    And my username should no longer be on the navbar
    And there should be a Log In Button on the navbar
