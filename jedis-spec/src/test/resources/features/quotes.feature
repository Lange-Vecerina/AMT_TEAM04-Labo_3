Feature: Application jedis

Scenario: Register a new jedi and a new lightsaber
  Given I have a jedi payload
  When I POST it to the /jedis endpoint
  Then I receive a 201 status code


Scenario: Register a new Lightsaber
  Given I have a lightsaber payload
  When I POST it to the /lightsabers endpoint
  Then I receive a 201 status code for the lightsaber

Scenario: get a jedi
  Given I have a jedi payload
  When I POST it to the /jedis endpoint
  Then I receive a 201 status code
  When I GET the jedi payload from the /jedis/ 5 endpoint
  Then I receive a 200 status code

Scenario: get lightsaber from jedi
    Given I have a jedi payload
    When I POST it to the /jedis endpoint
    Then I receive a 201 status code
    When I GET the lightsaber payload from the /jedis/ 5 /lightsabers endpoint
    Then I receive a 200 status code

Scenario: Register a new Jedi with a lightsaber
    Given I have a jedi payload
    And I have a lightsaber payload for the jedi
    When I POST it to the /jedis endpoint
    Then I receive a 201 status code
    When I PUT the lightsaber payload to the /jedis/ 5 /lightsabers endpoint
    Then I receive a 201 status code
