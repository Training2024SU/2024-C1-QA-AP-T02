Feature: Account Creation on reqres.in Platform

  As an user of reqres.in,
  I want to create a new account
  So that I can access to the platform.

  Background:
    Given the user is currently on the reqres.in platform.

  Scenario Outline: Successful Account Creation using POST
    When the user correctly enters their details
      | name   | job   |
      | <name> | <job> |
    Then they should be able to view their information along with a generated ID
    And the response should have a valid status code of 201
    Examples:
      | name                | job       |
      | johan@gmail.com     | johan     |
      | jorge@gmail.com     | jorge     |
      | juan_jose@gmail.com | juan_jose |
      | rojas@gmail.com     | rojas     |


