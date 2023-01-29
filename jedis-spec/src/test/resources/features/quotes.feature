Feature: Application quotes

Scenario: Register a new jedi
Given I have a jedi payload
When I POST it to the /jedis endpoint
Then I receive a 201 status code


