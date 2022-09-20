Feature: search Product and check Product Deals

  @OffersPage
  Scenario Outline: search experience for both home and offers page
    Given User on Green Cart Landing Page
    When user search with shortname <Name> and extracts name of product
    Then user search with same shortname on offers page
    And check if product exists

    Examples: 
      | Name |
      | Tom  |
      | Beet |
      | Bea  |
