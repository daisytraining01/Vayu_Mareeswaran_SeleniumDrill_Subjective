Feature: New Tours
  @Launch
  Scenario: Launch New Tours
    Given Launch Browser
    When Get New Tours Login Base URL
    And Validate the correctness of Landing Page
    Then Close the Browser

  @Login
  Scenario Outline: Validate Login Functionality
    Given Launch the New Tours
    When Enter user name as "<Username>" and Password as "<password>"
    And Click on Login
    Then Successful Login
    Examples: 
      | Username | password |
      | abc      | abc      |