Feature: About us
  In order to learn more about the company
  As a user on the DemoBlaze website
  I want to open the About Us modal and view its content

  @Happy
  Scenario: User can view and close the About Us modal
    Given I am on the DemoBlaze homepage
    When I click on the About us link
    Then the About Us popup should appear
    And I should be able to close the popup