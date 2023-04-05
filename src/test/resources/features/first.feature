@tag1

  Feature: User Story One

    Scenario: Open the Login Page
      Given I open login page

      Given I login as a registered user

      Given I switch to open products page

      Given I search "t shirts" on the products page


      Given I select "two shirts" I want and add to cart

      Given I remove one shirt I do not want from the cart

      Given I proceed to checkout to place my order

      Given I add my payment info to confirm my order

      Given I download the invoice for the order I placed

