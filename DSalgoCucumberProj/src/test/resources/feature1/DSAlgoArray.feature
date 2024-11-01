Feature: feature to test navigation for Array
Background: validate login
    Given The user is in homepage
    When the user gives proper loginid, password
    Then the user is logged in
   
@test 
Scenario: Validate getting started is working
	 Given The user is on homepage
    When user clicks on Get Started button
    Then user be directed to "Array" page  

@test
Scenario: Validate arrays in python page is working 
 		Given The user is on Array page
    When The user clicks Arrays in Python button 
    Then The user should be redirected to "Arrays in Python page"
  
@test   
Scenario: Validate tryEditor with a Run button to test is working 
		Given The user is on the Array in Python Page
    When TThe user clicks Try Here button of Array in Python Page
    Then The user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    
@test    
Scenario: Validate Arrays using List is working 
    GivenThe user is on the Array Page
    When The user click Array using list link
    Then The user should be redirected to "Arrays using List" page
    
@test
Scenario: Validate Arrays using List try Editor is working 
    Given The user is on the Array using list page
    When The user clicks Try Here button of Array Using List Page
    Then The user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
   
@test
Scenario: Validate Basic Operations in List page  is working 
    Given The user is on the Array Page
    When The user click Array basic operation in Lists
    Then The user should be redirected to "Basic Operations in Lists" page
    
@test
Scenario: Validate Basic Operations in List Try Here is working 
    Given The user is on the Basic operations in Lists page
    When The user clicks Try Here button of Operations in Lists
    Then The user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"

@test    
Scenario: Validate Applications of Array page is working 
    Given The user is on the Array Page
    When The user click Applications of Array link
    Then The user should be redirected to "Applications of Array" page
  
@test    
Scenario: Validate Basic Operations in Applications of Array page is working 
    Given The user is on the  Applications of Array page
    When The user clicks Try Here button in Applications of Array page
    Then The The user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    
@test
Scenario: Validate Array Python Editor is working 
    Given The user is on the Python Editor
    When The user write the valid python code in Editor and Click the Run button
    Then The user should able to see output in the console
    
@test
Scenario: Validate Array Python Editor is working 
    Given The user is on the Python Editor
    When The user write the invalid code in Editor
    Then The user should able to see an error message in alert window
