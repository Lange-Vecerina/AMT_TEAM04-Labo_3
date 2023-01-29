Feature: Application jedis

Scenario: Register a new jedi
  Given I have a jedi payload
  When I POST it to the /jedis endpoint
  Then I receive a 201 status code


Scenario: Register a new Lightsaber
  Given I have a lightsaber payload
  When I POST it to the /lightsabers endpoint
  Then I receive a 201 status code for the lightsaber