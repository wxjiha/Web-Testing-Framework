Feature: Checkout
  In order to successfully purchase items
  As a registered user
  I want to be able to place an order and receive confirmation

  Background:
    Given I have a product in cart

  @Happy
  Scenario Outline: Checkout is successful
    When I click the place order button
    And I fill out every field "<name>", "<country>", "<city>", "<card>", "<month>", "<year>"
    And I click on Purchase
    Then I should receive a pop up confirming my order
    And the message should include my details, the order ID, amount, and card number

    Examples:
      | name  | country | city       | card       | month | year |
      | Laura | UK      | Birmingham | 1234567890 | 12    | 2028 |
      | Alice | UK      | London     | 9876543210 | 06    | 2027 |
      | Bob   | Canada  | Toronto    | 5555555555 | 11    | 2024 |

  @Negative
  Scenario: User tries to place an order without entering Name and Credit Card
    When I click the place order button
    And I leave "Name" blank
    And I leave "Credit Card" blank
    And I click on Purchase
    Then the system should display an alert "Please fill out Name and Credit card"