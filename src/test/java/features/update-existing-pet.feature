Feature: Update an existing pet

  @pet
  Scenario: Verify update of an existing pet
    Given I set the endpoint input data from "updatepetwithformdata.json"
    When I update the existing pet store
    Then I verify response data to check the update

