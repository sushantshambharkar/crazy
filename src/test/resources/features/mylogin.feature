Feature: test login

Scenario: Test Positive 
	Given user opens the home page
	When  user enters search text "nikon"
	When  user clicks on next page
	Then  user gets the price list
