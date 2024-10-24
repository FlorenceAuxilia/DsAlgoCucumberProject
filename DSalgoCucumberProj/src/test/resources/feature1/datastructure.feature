Feature: Data Structure Introduction page validation

@DataStructure
  Scenario:  Data Structure page validation using Get Started button
    Given The user is in home page after login
    When The user clicks the Getting Started button in Data Structures-Introduction panel
    Then The user should be directed to data structure "Data Structures-Introduction" Page
    
@DataStructure
  Scenario: Time Complexity link validation
    Given The user clicks the Getting Started button in Data Structures-Introduction panel
    When The user clicks Time Complexity link
    Then The user should be directed to Time Complexity "Time Complexity" page
    
@DataStructure
  Scenario: Implementation Time Complexity Try here button validation
    Given The user clicks the Getting Started button in Data Structures-Introduction panel
    And The user clicks Time Complexity link
    When The user clicks on time complexity Try here button
    Then The user redirect to time complexity tryEditor page
 
 @DataStructure
  Scenario: Implementation Time Complexity Try Editor validation----valid scenario
   Given The user clicks the Getting Started button in Data Structures-Introduction panel
    And The user clicks Time Complexity link
    And The user clicks on time complexity Try here button
    When The user enter a python code to print "hello"
    And The user clicks on run button valid scenario
    Then User is able to see output in console "hello"
    
 @DataStructure
  Scenario: Implementation Time Complexity Try Editor validation---Invalid scenario with popup handling
    Given The user clicks the Getting Started button in Data Structures-Introduction panel
    And The user clicks Time Complexity link
    And The user clicks on time complexity Try here button
    When The user enter a Invalid python code to print "hi"
    Then popup Window handle 