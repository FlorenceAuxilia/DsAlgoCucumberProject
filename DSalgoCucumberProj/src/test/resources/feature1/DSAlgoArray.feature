Feature: feature to test Array page functionality


@array 
Scenario: Validate getting started is working
	 	Given The user is on the  home page with successful login
    When The user clicks on Get Started button
    Then user should be directed to "Array" page 
    

@array
Scenario: Validate arrays in python page is working 
 		Given The user is on Array page
    When The user clicks Arrays in Python	link 
    Then The user redirected to "Arrays in Python" page
	
@array
Scenario: Validate Basic Operations in List page  is working 
    Given The user is on the Array Page
    When The user click Array basic operation in Lists
    Then The user should be redirected to "Basic Operations in Lists" page  
   
   
@array       
Scenario: Validate Applications of Array page is working 
    Given The user is on the Array Page
    When The user click Applications of Array link
    Then The user should be redirected to "Applications of Array" page 
    
@array    
Scenario: Validate Arrays using List is working 
   Given The user is on the Array Page
	 	When The user clicks Arrays using List link 
 		Then The user should be on the Arrays using List page   
 		
@array   
Scenario: Validate tryEditor with a Run button to test is working 
		Given The user is on the Array in Python Page
    When The user clicks Try Here button of Array in Python Page
    Then The user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    
@array
Scenario: Validate Arrays using List try Editor is working 
    Given The user is on the Array using list page
    When The user clicks Try Here button of Array Using List Page
    Then  User should be redirected to Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"   
    
@array
Scenario: Validate Basic Operations in List Try Here is working 
    Given The user is on the Basic operations in Lists page
    When The user clicks Try Here button of Operations in Lists
    Then  user should be redirected to a page having an Python Editor with a url 
    
     
@array    
Scenario: Validate Basic Operations in Applications of Array page is working 
    Given The user is on the  Applications of Array page
    When The user clicks Try Here button in Applications of Array page
    Then The user should redirected to Python Editor page
    
  
@array
Scenario: Validate Array Python Editor is working 
    Given The user is on the Python Editor
    When The user enter valid python code print "hello" and clicks run button
    Then User is able to see the output "hello" in console  

    
@array
Scenario: Validate Array Python Editor is working 
    Given The user is on the Python Editor
    When The user enter invalid python code "hello world!" and clicks run button
    Then User should see the error message


@array
Scenario: Validate Array Practice Questions is working 
    Given The use is on the  Array in Python Page
    When The user click Practice Questions link
    Then The user redirected to Practice page
    
   
@array
Scenario: Validate Array Practice Questions is working 
    Given The use is on the  Array Practice Questions Page
    When The user click Search the array link
    Then The user should be redirected to a page having an Python Editor
	
@array
Scenario: Validate Array Practice Questions is working 
    Given The use is on the  Array Practice Questions Page
    When The user click Max Consecutive Ones link
    Then The user should be redirected to a page having an Python Editor2
	
@array
Scenario: Validate Array Practice Questions is working 
    Given The use is on the  Array Practice Questions Page
    When The user click Find Numbers with Even Numbers of digits link
    Then The user should be redirected to a page having an Python Editor3

@array
Scenario: Validate Array Practice Questions is working 
    Given The use is on the  Array Practice Questions Page
    When The user click Squares of a sorted Array link
    Then The user should be redirected to a page having an Python Editor4
	
@array  
Scenario: Array Practice Questions python editor Submit button is working 
    Given The user is on the Array Practice Questions page 
    When The user clicks submit button
    Then The user should get error message in console
    


  