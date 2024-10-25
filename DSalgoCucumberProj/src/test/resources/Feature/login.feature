@login
Feature: Signin validation

Scenario Outline: Check login is sucessful with valid credentials
Given The user is in login page
When Enter the <username> and <password> as
And Click on Login
Then Homepage should be displayed

Examples:
	|username|password|
	|ninja4|Tiger123@|
	
Scenario Outline: Check login is not sucessful with invalid credentials
Given The user is in login page
When Enter the <username> and <password> as
And Click on Login
Then Homepage should not be displayed

Examples:
	|username|password|
	|ninja4|Tiger|
	|ninja|Tiger123@|
	
Scenario: Check able to navigate to registration page 
Given The user is in login page
When Click register Button 
Then Registartion page should be displayed


	
	









#Feature: Signin validation
#
#@validCredentials
#  Scenario Outline: login with valid credential
#    Given User is on signin page url 
#    When User enters valid username "<username>" into username field
#    And User enters valid password "<password>" into password field
#    And User clicks on Login button
#    Then The user should successfully land in Data Structure Home Page 
# 
# 
#    Examples: 
#      | username | password  |
#      | ninja4   | Tiger123@ |
#   
