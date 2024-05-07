Feature: User register
  As user of of the reqres app
  want to create a new account
  For access to the platform.

  Background:
    Given the user is currently on the reqres.in platform.

  @CompleteInfo
  Scenario Outline: Successful Account Creation
    When the user correctly enters their details
      | name   | job   |
      | <name> | <job> |
    And send the request for the user creation
    Then they should be able to view their information along with a generated ID
    And the response should indicate a valid status code of 201
    Examples:
      | name            | job   |
      | juanito@gmail.com | ladron |
      | pedro@gmail.com | navaja |
      | carlitos123@gmail.com | rugrats |
      | hola_@gmail.com | correo |


    @BadRequest
  Scenario: Attempt to Create Account with Only Job Specified
    When the user attempts to create an account with only job specified
      | name | job     |
      |      | boss  |
    And send the request for the user creation
    Then they should receive a response with a status code of 400 indicating bad request

