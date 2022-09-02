Feature: Sauce demo homepage
  Background: User is in sauce demo homepage
    Given Im in sauce demo web page

    @CartNumberisincremented
    Scenario: Add a product to the cart and number is incremented
      Given I login into sauce labs page
      And I click Add to cart button of any product
      Then Cart number is displayed and incremented

    @LowtoHighsort
    Scenario: Select Low to high sort option
      Given I login into sauce lab page
      And I choose low to high option from the combo box
      Then All products get sort in low to high order
