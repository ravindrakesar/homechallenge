Feature: Adding a new pet to the petstore

  @pet
  Scenario: Add a new pet to the pet store
    Given I define the endpoint input data from "addnewpet.json"
    When I add the new pet to the store
    Then I verify that the pet is added to the store