Feature: Update an existing pet

  @pet
  Scenario: Verify update of an existing pet
    Given I have request URL for updating a pet
    When I update the existing pet store
    Then I verify response data to check the update

