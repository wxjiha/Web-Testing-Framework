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

  @Happy
  Scenario Outline: Adding a Product to Cart
    Given I am on the homepage
    And I click on the "<productName>"
    When I am on the product detail page
    And I click Add to Cart
    Then I should see a confirmation alert
    And On the cart page, I should have "<productNumber>" items in my cart
    Examples:
      | productNumber | productName       |
      | 1              | Nexus 6           |
      | 2              | Sony vaio i7      |
      | 3              | Samsung galaxy s6 |
