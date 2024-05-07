Feature: Update Post on jsonplaceholder.typicode.com platform

  As a user of the platform
  I want to update my posts
  So that I can modify my posts

  Background:
    Given the user is registered on the jsonplaceholder platform

  Scenario Outline: Update Post Successfully using PUT
    When the user updates the post with id <id> with the following data
      | id   | title   | body   | userId   |
      | <id> | <title> | <body> | <userId> |
    Then the response should have a valid status code of 200
    Examples:
      | id | title           | body           | userId |
      | 1  | updated title   | updated body   | 1      |
      | 2  | updated title 2 | updated body 2 | 1      |
