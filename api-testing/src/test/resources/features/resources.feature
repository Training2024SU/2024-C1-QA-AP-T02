@Resources
Feature: Resources management via REST API
  As an integration system I
  WANT to manage the information about the resources in the service
  SO THAT I can keep the information up to date and give it to the users

  Scenario Outline: Obtain resource info
    Given the resource with id <id>
    When the system requests the resource's info
    Then it should receive a success response
    And it should obtain the complete resource's info with id <id> and name "<name>"
    Examples:
      | id | name         |
      | 10 | mimosa       |
      | 2  | fuchsia rose |