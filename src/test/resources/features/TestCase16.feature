Feature: Automation Exercise 16
  Background:
    Given User navigate to url "mainUrl"
    And User verify that home page is visible successfully
    And User click " Signup / Login" button on Menu
    When User create new user "name", "email", "password"
    And User click " Signup / Login" button on Menu
    And User click " Logout" button on Menu
    When User navigate to url "loginUrl"

  @TC001_Login
  Scenario: TC001 User login and take a product
    And User click " Signup / Login" button on Menu
    And User fill "email" and "password"
    And User verify " Logged in as " at top
    And User click " Products" button on Menu
    When User hover over product and click Add to cart
    And User click View Cart button
    And User click Proceed To Checkout
    Then User verify Address Details and Review Your Order
    And User enter description in comment text area and click Place Order
    And User enter payment details: "name_on_card", "card_number", "cvc", "expiry_month", "expiry_year"
    ##Then User verify success message "messageOrderSuccess"
    When User click " Delete Account" button on Menu
    Then User Verify "messageDelete" and click Continue button
    And User closes the application


