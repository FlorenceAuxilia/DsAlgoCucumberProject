@LinkedList

Feature: Linked List page validation

Background:
Given   The user is in home page after successful login

@LinkedList
Scenario: LinkedList page validation using Get Started button
When The user clicks the Getting Started button in LinkedList Panel
Then The user should be Redirected to Linked List

 @LinkedList  
 Scenario Outline:LinkedList page validation link land in correct page
    Given The user is in the LinkedList page after logged in
    When The user clicks <link name> Link
    Then The user should be directed to  <link name> page
    
    Examples:
	|link name|
	|"Introduction"|
	|"Creating Linked List"|
	|"Types Linked List"|
	|"Implement Linked List in python "| 
	|"Traversal"|
	|"Insertion"|
	|"Deletion"|
	
	@Linked List   
 Scenario Outline:LinkedLinkedList page validation link land in correct page
    Given The user is in the LinkedList after logged in
    When The user clicks <link name> Link
    And The user clicks "Practice Questions" Link
    
    
    Examples:
	|link name|
	|"Introduction"|
	|"Creating Linked List"|
	|"Types Linked List"|
	|"Implement Linked List in python "| 
	|"Traversal"|
	|"Insertion"|
	|"Deletion"|
	
	
     @LinkedList
  Scenario Outline:  Try here button validation
    Given The user is in the Linked List page after logged in
    And The user clicks <link name> Link
   When The user clicks  Try here button
    Then The user is redirect to tryEditor page  
	
    Then The Practice question page should be displayed
    
    
    Examples:
	|link name|
	|"Introduction"|
	|"Creating Linked List"|
	|"Types Linked List"|
	|"Implement Linked List in python "| 
	|"Traversal"|
	|"Insertion"|
	|"Deletion"|
	
	Scenario Outline: Types of linkedlist Try Editor validation----valid scenario
    Given The user is in the Linked Listpage after logged in
    And The user clicks <link name> Link
   When The user clicks  Try here button
  When The user enter valid python code print "hello"
    And The user clicks run button valid scenario
    Then User is able to see the output in console "hello" 
     Examples:
     	|link name|
	|"Introduction"|
	|"Creating Linked List"|
	|"Types Linked List"|
	|"Implement Linked List in python "| 
	|"Traversal"|
	|"Insertion"|
	|"Deletion"|
	
	

     Scenario Outline: Types of linkedlist Try Editor validation----invalid scenario
    Given The user is in the LinkedList page after logged in
	And The user clicks <link name> Link
     When The user clicks  Try here button
	 When The user enter invalid python code "My name "
    And The user clicks run button and sees an alert 
    
 
Examples
      	|link name|
	|"Introduction"|
	|"Creating Linked List"|
	|"Types Linked List"|
	|"Implement Linked List in python "| 
	|"Traversal"|
	|"Insertion"|
	|"Deletion"|
	
	
	
