Feature: new user registration

Background:
Given The user is on the new user registration page

#@registration_successful
#Scenario Outline: new user registration with valid data
    #Given The user is on the new user registration page
    #When The user clicks Register button after entering  with valid "<username>" and "<password>" and "<confirmPassword>" in related textbox
    #Then The user should be redirected to Home Page of DS Algo with new use account
#
#Examples:
#	|username|password|confirmPassword|
#	|sprint5|abcd12345@|abcd12345@|

####XLSX0
@registration_successful
Scenario Outline: new user registration with valid data
    Given The user is on the new user registration page
    When The user clicks Register button after entering  with valid "<SheetName>" and <RowNumber> in related textbox
    Then The user should be redirected to Home Page of DS Algo with new user account

Examples:
	|SheetName|RowNumber|
	|Registration|0|
		
	 

#@registration_unsuccessful
#Scenario Outline: user registration with invalid data
    #Given The user is on the new user registration page 
    #When User clicks Register button with invalid spacechar in "<username>" and valid "<password>" and "<confirmPassword>"
    #Then The user is not able to see error msg after entering invalid data and user redirected to empty password textbox 
    #
#Examples:
#	|username|password|confirmPassword|
#	|ninja&4|abcd1234|abcd1234|

####XLSX1
Scenario Outline: user registration with invalid data
    Given The user is on the new user registration page 
    When User clicks Register button with invalid spacechar in "<SheetName>" and valid  <RowNumber>
    Then The user is not able to see error msg after entering invalid data and user redirected to empty password textbox 
    
Examples:
	|SheetName|RowNumber|RowNumber|
	|Registration|1|1|


#@registration_unsuccessful
#Scenario Outline: user registration with invalid data
    #Given The user is on the new user registration page 
    #When 	The user clicks Register button after entering valid "<username>" and numeric "<password>" and "<confirmPassword>" 
    #Then 	User can see warning message
    #
#Examples:
#	|username|password|confirmPassword|
#	|ninja4|12345678|12345678|
#	
####XLSX2

@registration_unsuccessful
Scenario Outline: user registration with invalid data
    Given The user is on the new user registration page 
    When 	The user clicks Register button after entering valid username "<SheetName>"  and numeric <RowNumber>  
    Then 	User can see warning message
    
Examples:
	|SheetName|RowNumber|RowNumber|
	|Registration|2|2|

#@registration_unsuccessful
#Scenario Outline: user registration with invalid data
    #Given The user is on the new user registration page 
    #When The user clicks Register button after entering a valid "<username>" and less than Eight characters "<password>" and "<confirmPassword>" 
    #Then User can see warning message1
    #
#Examples:
#	|username|password|confirmPassword|
#	|ninja4|abcd12@|abcd12@| 
#	
####XLSX3
@registration_unsuccessful
Scenario Outline: user registration with invalid data
    Given The user is on the new user registration page 
    When The user clicks Register button after entering a valid username "<SheetName>" and less than Eight characters <RowNumber>  
    Then User can see warning message1
    
Examples:
	|SheetName|RowNumber|RowNumber|
	|Registration|3|3| 

#@registration_unsuccessful
#Scenario Outline: user registration with invalid data
    #Given The user is on the new user registration page 
    #When 	The user clicks Register button after entering valid "<username>" and different passwords in "<password>" and "<confirmPassword>"
    #Then 	The user should able to see an password warning message 
#
#Examples:
#	|username|password|confirmPassword|
#	|ninja4|abcd123@|abcd124@|  
#	
#	  ####XLSX4
 @registration_unsuccessful
Scenario Outline: user registration with invalid data
    Given The user is on the new user registration page 
    When 	The user clicks Register button after entering valid username "<SheetName>" and different passwords in <RowNumber> 
    Then 	The user should able to see an password warning message 

Examples:
	|SheetName|RowNumber|RowNumber|
	|Registration|4|4|   


@register_LoginLink
Scenario: Check able to navigate to login page 
		Given The user is on registration page
		When Click login  
		Then login page should be displayed
	
@registration_unsuccessful
Scenario: Check for error message if user missed to put value in any field
Given The user is on registration page
When  User clicked register button  
Then Error popup should display

@registration_unsuccessful
Scenario: Check for error message if user missed to put value in any field
Given The user is on registration page
When  User clicked register button  
Then Error popup should display

#@registration_unsuccessful
#Scenario Outline: cursor check
#Given The user is on registration page
#When  User try to enter invalid value in "<username>" and  "<password>" and "<confirmPassword>"
#Then 	user is not getting Error message after inputing invalid value in respective field
#
#Examples:
#	|username|password|confirmPassword|
#	|ninja4!|abcd123@|abcd123@|
#	|ninja4|abcd123|abcd123|
#	|ninja4|abcd123@|abcd123| 

####XLSX5
@registration_unsuccessful
Scenario Outline: cursor check
Given The user is on registration page
When  User try to enter invalid value in username "<SheetName>" and  <RowNumber> 
Then 	user is not getting Error message after inputing invalid value in respective field

Examples:
	|SheetName|RowNumber|RowNumber|
	|Registration|5|5| 
	|Registration|6|6|
	|Registration|7|7|

#@registration_unsuccessful
#Scenario Outline: username will not accept more characters as setted
#Given The user is on registration page
#When  User clicked register button with trying to enter more than difined limit characters  in "<username>" 
#Then 	user not able to see Error message after the character limit reached in username_field
#
#Examples:
#	|username|
#	|sprintssnkanxklajwdoqwijsoiwswqdkqwdqdkdqdwqqwqwdqwqwdwqdqwdkwqhdqdqdwqdqwdwqdsprintssnkanxklajwdoqwijsoiwswqdkqwdqdkdqdwqqwqwdqwqwdwqdqwdkwqhdqdqdwqd|

####XLSX6
@registration_unsuccessful
Scenario Outline: username will not accept more characters as setted
Given The user is on registration page
When  User clicked register button with trying to enter more than difined limit characters  in username "<SheetName>" and <RowNumber> 
Then 	user not able to see Error message after the character limit reached in username_field

Examples:
	|SheetName|RowNumber|RowNumber|
	|Registration|8|8| 