Feature: search and add order to Cart

  @PlaceOrder
  Scenario Outline: search experience for both home and offers page
    Given User on Green Cart Landing Page
    When user search with shortname <Name> and extracts name of product
    And adds <Number> to cart
    Then proceeds to checkout
    And check if cart is as expected

    Examples: 
      | Name | Number |
      | Tom  |      2 |
      | Beet |      3 |
