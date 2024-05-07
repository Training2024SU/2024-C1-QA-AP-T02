Feature: Register New User
  I as the user on the services of Reqres
  Want to Register myself as a New User
  for having access to the services

  @test1
  Scenario Outline: Successful Account Creation
    Given the user is in the platform
    When the user correctly enters their details
      | name | <name> |
      | job  | <job>  |
    Then it should see his information in the system
    And it should get a 201 code
    Examples:
      | name     | job        |
      | morpheus | leader     |
      | jorge    | chambeador |

