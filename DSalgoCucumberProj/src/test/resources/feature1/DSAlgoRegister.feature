Feature: new user registration

@registration_successful
Scenario: new user registration with valid data
    Given The user is on the new user registration page
    When The user clicks Register button after entering  with valid username, password and password confirmation in related textbox
    Then The user should be redirected to Home Page of DS Algo and can see  successful message "New Account Created" and you are logged in as "provided Username" on the DS Algo Home Page

@registration_unsuccessful
  Scenario: user registration with invalid data
    Given The user is on the new user registration page 
    When The user clicks Register button with all fields empty
    Then The error " Please fill out this field " appears below Username textbox

@registration_unsuccessful
Scenario: user registration with invalid data
    Given The user is on the new user registration page 
    When The user clicks Register button after entering Username with other fields empty
    Then The error message "Please fill out this field" appears below Password textbox
    
@registration_unsuccessful
Scenario: user registration with invalid data
    Given The user is on the new user registration page 
    When The user clicks Register button after entering Username and password with Password Confirmation field empty
    Then Then The error message "Please fill out this field " appears below  Password Confirmation textbox    
    
@registration_unsuccessful
Scenario: user registration with invalid data
    Given The user is on the new user registration page 
    When The user clicks Register button after entering a username other than letters,digits and spacebar characters @/./+/-/_
    Then The user is not able to see error msg after entering invalid data and user redirected to empty password textbox 
    
@registration_unsuccessful
Scenario: user registration with invalid data
    Given The user is on the new user registration page 
    When 	The user clicks Register button after entering a password with only numeric data 
    Then 	The user is not able to see error msg after entering invalid data but can see an password warning message "password_mismatch:The two password fields didn’t match" with redirected to empty password confirmation textbox "password_mismatch:The two password fields didn’t match"
    
@registration_unsuccessful
Scenario: user registration with invalid data
    Given The user is on the new user registration page 
    When The user clicks Register buttonafter entering a Password with characters less than 8
    Then The user is not able to see error msg after entering invalid data but can see an password warning message "password_mismatch:The two password fields didn’t match " with redirecting to register button enable
    
@registration_unsuccessful
Scenario: user registration with invalid data
    Given The user is on the new user registration page 
    When 	The user clicks Register button after entering different passwords in Password and Password Confirmation textbox
    Then 	The user should able to see an pwd warning message "password_mismatch:The two password fields didn’t match"
    
  
