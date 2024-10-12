Feature: Automation Exercise Api

  @TC001_productList
  Scenario: TC001 product list
    Given User sends  Get request "productList"
    Then User validates statuscode "200"

  @TC002_productListNagative
  Scenario: TC002 product list negative case
    Given User sends  Post request "productList"
    Then User validates statuscode "405"