@Users @ReqRes
Feature: Users

  Scenario: Obtain user profile info
    Given A user is logged in
    When he requests its profile data
    Then he should see his correct information