@login
Feature: Login to Dsalgo

Background:
Given The user is in login page
#And Launch the URL


#@login
#Scenario Outline: Check login is sucessful with valid credentials
#Given The user is in login page
#When Enter the <username> and <password> as
#And Click on Login
#Then Homepage should be displayed
#
#Examples:
#	|username|password|
#	|ninja4|Tiger123@|

@login
Scenario Outline: Check login is sucessful with valid credentials
Given The user is in login page
When Enter the Credentials sheetname "<SheetName>" and rownumber <RowNumber>
And Click on Login
Then Homepage should be displayed

Examples:
	| SheetName | RowNumber |
      | Credentia   |         0 |


	
@login
Scenario: Check for error message only username 
Given The user is in login page
When Enter the username
And Click on Login
Then Error popup should be displayed

@login
Scenario: Check for error message only password 
Given The user is in login page
When Enter the password
And Click on Login
Then Error popup should be displayed	
#
#@login	
#Scenario Outline: Check login is not sucessful with invalid credentials
#Given The user is in login page
#When Enter the <username> and <password> as
#And Click on Login
#Then Error Message should be displayed
#
#Examples:
#	|username|password|
#	|ninja4|Tiger|
#	|ninja|Tiger123@|


@login	
Scenario Outline: Check login is not sucessful with invalid credentials
Given The user is in login page
When Enter the Credentials sheetname "<SheetName>" and rownumber <RowNumber>
And Click on Login
Then Error Message should be displayed

Examples:
	| SheetName | RowNumber |
      | Credentia   |         1 |
        | Credentia   |         2 |


#



#
#	
@login	
Scenario: Check able to navigate to registration page 
Given The user is in login page
When Click register Button 
Then Registartion page should be displayed
