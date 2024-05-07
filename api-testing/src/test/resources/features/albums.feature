@Albums @jsonPlaceholder
Feature: Albums

  Background: User's albums
    Given A list of albums from a user

  Scenario: Create a new empty album
    When the user creates a new album
    Then he should get a successful response
    And he should get the id assigned to that album

  Scenario: Delete a user album
    When the user deletes one of the albums
    Then he should get a successful response
    And he shouldn't see that album anymore in his list

  Scenario: Add a photo to a album
    When the user adds a photo to one album
    Then he should get a successful response
    And he should get the id assigned to the new photo

  Scenario: Delete a photo
    When the user removes a photo from one album
    Then he should get a successful response
