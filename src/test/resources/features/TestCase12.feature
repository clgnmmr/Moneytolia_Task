Feature: Automation Exercise

  @TC_001_products
  Scenario: Add products to cart
    Given User navigate to url "mainUrl"
    And User verify that home page is visible successfully
    And User click " Products" button on Menu
    When User hover over product and click Add to cart
    And User click Continue Shopping button
    When User hover over product and click Add to cart
    And User click View Cart button
    Then User verify their prices, quantity and total price
    And User closes the application