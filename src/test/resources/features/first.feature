@tag1

  Feature: User Story One

    Scenario: Open the Login Page
      Given I open login page

    Scenario: Login with Valid Credentials
      Given I login as a registered user

    Scenario: Open the Products Page
      Given I switch to open products page

    Scenario: Search T Shirts in the Products Page
      Given I search t shirts on the products page

    Scenario: Select two T Shirts from the Products Page
      Given I select two shirts I want and add to cart

    Scenario: Remove one T Shirt from the Cart
      Given I remove one shirt I do not want from the cart

    Scenario: Proceed to Checkout to place the Order
      Given I proceed to checkout to place my order

    Scenario: Provide Payment Info to confirm the Order
      Given I add my payment info to confirm my order

    Scenario: Download Invoice for the Order
      Given I download the invoice for the order I placed

