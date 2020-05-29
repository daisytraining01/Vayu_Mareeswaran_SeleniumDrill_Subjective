Feature: New Tours

  @Smoke
  Scenario Outline: Validate Login Functionality
    Given Launch the New Tours
    When Enter user name as "<Username>" and Password as "<password>"
    And Click on Login
    Then Successful Login
    Examples: 
      | Username | password |
      | abc      | abc      |