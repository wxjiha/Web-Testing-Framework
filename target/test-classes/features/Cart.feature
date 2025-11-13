Feature: Cart

  In order to be able to buy items
  As a user of the DemoBlaze website
  I want to be able to add items to my cart or remove them

  @Happy
  Scenario: Choosing a Category
    Given I am on the homepage
    When I click on the Monitors category
    Then I should see only the two monitors

  @Happy
  Scenario Outline: View Product Details
    Given I am on the homepage
    When I click on the "<productNames>"
    Then I should land on the product detail page for "<productNames>"
    Examples:
      | productNames      |
      | Nexus 6           |
      | Sony vaio i7      |
      | Samsung galaxy s6 |
