Feature: To verify all get APIs by sending id, status or tags

  @pet
  Scenario: Verify pet by id
    Given I send id to the request to get pet details
    Then I verify response data


  @pet
  Scenario: Verify pet by tags
    Given I send tags to the request to get pet details
    Then I check response status code

  @pet
  Scenario: Verify pet by status
    Given I send status to the request to get pet details
    Then I check response status code

