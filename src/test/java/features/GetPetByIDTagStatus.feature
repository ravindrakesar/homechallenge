Feature: To verify all get APIs by sending id, status or tags

  @pet
  Scenario: Verify pet by id
    Given I verify the pet by sending id

  @pet
  Scenario: Verify pet by tags
    Given I verify the pet by sending tags

  @pet
  Scenario: Verify pet by status
    Given I verify the pet by sending status

