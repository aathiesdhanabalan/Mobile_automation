Feature: Category Search

  Scenario: Verify the category search button works correctly
    Given I am on Blibli app
    When I click categories button
    Then I choose a categories in the list
    Then The product description page is opened
    And I close the app