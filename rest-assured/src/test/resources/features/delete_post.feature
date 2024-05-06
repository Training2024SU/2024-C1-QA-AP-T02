Feature: Delete Post on jsonplaceholder.typicode.com platform

  As a user of the platform
  I want to delete my posts
  So that I can clean my history

  Background:
    Given the user is registered on the jsonplaceholder platform

  Scenario Outline: Delete Post Successfully
    When the user deletes its post with id <id> successfully
    Then the response should have a valid status code of 200
    Examples:
    |id|
    | 1 |
    | 2 |
    | 3 |