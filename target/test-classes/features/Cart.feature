Feature: Cart

  In order to be able to buy items
  As a user of the DemoBlaze website
  I want to be able to add items to my cart or remove them

  Scenario: Choosing a Category
    Given I am on the homepage
    When I click on the Monitors category
    Then I should see only the two monitors

  Scenario Outline: View Product Details
    Given I am on the homepage
    When I click on the "<productNames>"
    Then I should land on the product detail page for "<productNames>"
    Examples:
      | productNames      |
      | Nexus 6           |
      | Sony vaio i7      |
      | Samsung galaxy s6 |

  @AccumulateCart
  Scenario Outline: Adding Products to Cart
    Given I am on the homepage
    And I click on the "<productName>"
    When I am on the product detail page
    And I click Add to Cart
    Then I should see a confirmation alert
    And On the cart page, I should have "<productNumber>" items in my cart
    And My Cart total should be "<cumulativeTotal>"
    Examples:
      | productNumber  | productName       | cumulativeTotal |
      | 1              | Nexus 6           | 650             |
      | 2              | Sony vaio i7      | 1440            |
      | 3              | Samsung galaxy s6 | 1800            |

  Scenario: Removing a Product from Cart
    Given I am on the homepage
    And I click on the "Nexus 6"
    And I Add the item to cart
    When I go to the cart page
    And I click on the delete button
    Then My cart should be empty

  Scenario: Quantity Changes when Product is added twice
    Given I am on the homepage
    And I click on the "Nexus 6"
    When I am on the product detail page
    And I Add the item to cart twice
    Then On the cart page, I should have "2" items in my cart
    And My Cart total should be "1300"
