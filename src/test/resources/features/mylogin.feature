@feature=mylogin
Feature: mylogin

Scenario: Test Positive 
	Given user opens the home page
	When  user enters search text "dell"
	When  user clicks on next page
	Then  user gets the price list
	Then  user gets email
