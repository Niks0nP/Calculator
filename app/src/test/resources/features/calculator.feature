Feature: Kotlin

Scenario: Addition
    Given I enter first digit 5.0
    And I select operation "+"
    And I enter second digit 3.0
    When I calculate the result
    Then the result should be 8.0

  Scenario: Subtraction
    Given I enter first digit 10.0
    And I select operation "-"
    And I enter second digit 4.0
    When I calculate the result
    Then the result should be 6.0