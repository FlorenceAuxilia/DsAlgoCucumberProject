@graph
Feature: Graph page validation

Background:
Given GP The user is in home page after successful login

@graph
Scenario: Graph page validation using Get Started button
  When The user clicks the Getting Started button in Graph Panel
    Then The user should be directed to Graph Page
 @graph
 Scenario Outline:Graph page validation link land in correct page
    Given The user is in the Graph page after logged in
    When The user click <link name> Link
    Then The user should be directed to gp <link name> page

Examples:
	|link name|
	|"Graph"|
	|"Graph Representations"|
	
	  
 @graph
 Scenario Outline: Graph page validation link land in correct page
    Given The user is in the Graph page after logged in
    When The user click <link name> Link
    And The user click "Practice Questions" Link
    Then The GP Practice question page should be displayed

Examples:
	|link name|
	|"Graph"|
	|"Graph Representations"|
 
     @graph
  Scenario Outline:   Graph Try here button validation
    Given The user is in the Graph page after logged in
    And The user click <link name> Link
   When The user clicks  Graph page Try here button
    Then The user is redirect to  Graph tryEditor page       
   Examples:
	|link name|
	|"Graph"|
	|"Graph Representations"|
   
    @graph
  Scenario Outline: Operations in Graph Try Editor validation----valid scenario
    Given The user is in the Graph page after logged in
    And The user click <link name> Link
   When The user clicks  Graph page Try here button
  When The GPuser enter valid python code print "hello"
    And The GPuser clicks run button valid scenario
    Then GPUser is able to see the output in console "hello" 
     Examples:
	|link name|
	|"Graph"|
	|"Graph Representations"|
	
    @graph
     Scenario Outline: Operations in Graph Try Editor validation----invalid scenario
    Given The user is in the Graph page after logged in
	And The user click <link name> Link
     When The user clicks  Graph page Try here button
	 When The GPuser enter invalid python code "who am i"
    And The GPuser clicks run button and sees an alert 
    
      Examples:
	|link name|
	|"Graph"|
	|"Graph Representations"|
