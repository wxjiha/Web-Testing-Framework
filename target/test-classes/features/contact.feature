Feature: Contact Form

  In order to communicate with customer support
  As a user of the website
  I want to be able to send a message using the Contact form


  @Happy
  Scenario: Submit valid contact messages using Data Table
    Given I am on the home page for contact form
    And I have clicked on the "Contact" link
    And I enter the following contact information
      | email                | name       | message                                      |
      | testuser1@example.com | Priya      | I would like to know more about your products. |
      | testuser2@example.com | Raj        | Can you provide pricing details?              |
    When I click the "Send message" button
    Then I should see a popup message saying "Thanks for the message!"

  Scenario: Close button hides the Contact page
    Given I am on the home page for contact form
    And I have clicked on the "Contact" link
    When I click the "Close" button
    Then the Contact page should not be visible

  @Negative @KnownDefect
  Scenario: Contact form submits successfully with empty fields
    Given I am on the home page for contact form
    And I have clicked on the "Contact" link
    When I leave all fields (email, name, message) empty
    And I click the "Send message" button
    Then a popup saying "Thanks for the message!" should appear
