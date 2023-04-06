@tag1

  Feature: User Story One

    Scenario: Open the Login Page
      Given I open login page

      And I login as a registered user

      When I switch to open products page

      And I search "t shirts" on the products page

      And I select two shirts I want and add to cart

      When I remove one shirt I do not want from the cart

      And I proceed to checkout to place my order

      And I place my order in checkout

      When I add my payment info to confirm my order

      When I download the invoice for the order I placed

