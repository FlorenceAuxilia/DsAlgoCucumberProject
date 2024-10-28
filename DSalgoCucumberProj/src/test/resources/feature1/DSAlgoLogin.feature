@login
Feature: Login to Dsalgo

#Background:
#Given Open the Browser
#And Launch the URL


@login
Scenario Outline: Check login is sucessful with valid credentials
Given The user is in login page
When Enter the <username> and <password> as
And Click on Login
Then Homepage should be displayed

Examples:
	|username|password|
	|ninja4|Tiger123@|

@login	
Scenario Outline: Check login is not sucessful with invalid credentials
Given The user is in login page
When Enter the <username> and <password> as
And Click on Login
Then Error Message should be displayed

Examples:
	|username|password|
	|ninja4|Tiger|
	|ninja|Tiger123@|


	
@login	
Scenario: Check able to navigate to registration page 
Given The user is in login page
When Click register Button 
Then Registartion page should be displayed
