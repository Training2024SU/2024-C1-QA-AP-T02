Feature: Search User Information on reqres.in Platform

  As a registered user on reqres.in,
  I want to search for my information
  So that I can view all relevant details

  Background:
    Given the user is registered on the reqres.in platform

  @test1
  Scenario Outline: Successfully Search for User Information
    When the user enters their registered ID <id> in the database
    Then they should be able to view their information
      | id   | email   | firstName   | lastName   |
      | <id> | <email> | <firstName> | <lastName> |
    And the response should have a valid status code of 200
    Examples:
      | id | email                    | firstName | lastName |
      | 2  | janet.weaver@reqres.in   | Janet     | Weaver   |
      | 5  | charles.morris@reqres.in | Charles   | Morris   |