Feature: Product Page Test


  @Test
  Scenario: Ask_Seller_In_Product_Page
    Given User is on the Akakçe mobile app on the "android"
    When User continues without login
    And User searches "Laptop"
    When User applies filters on product list
      | Sub_Catogrory       | Apply_Filter |
      | Bilgisayar, Donanım | true         |
    When User orders by products starting "EXPENSIVE"
    And User selects the 10  product
    Then User should see the Satıcıya Git button on the product page
