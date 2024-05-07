@Albums
Feature: Albums
  Scenario: delete a user album
    Given A list of albums from a user
    When he deletes one of the albums
    Then he should get a successful response
    And he shouldn't see that album anymore in his list
