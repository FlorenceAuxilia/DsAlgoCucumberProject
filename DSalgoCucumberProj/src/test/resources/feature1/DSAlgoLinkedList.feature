@linkedList
Feature: LinkedList 

 Background:
 Given The user in homepage after succesful login
 
 @linkedList
 Scenario: linkedList page validation using getting stated button
 When      The user clicks the getting started button in Linked List panel
 Then      The user connect to Linked List page
 
 @linkedList
 Scenario Outline:linkedList page validation link land to correct page
 Given The user in the linkedlist page after logged in
 When The user clicks <link name> Link 
 Then The user to be directed to linked list <link name> page 
 Examples:
 	|link name|
	|"Introduction"|
	|"Creating Linked List"|
  |"Types of Linked List"|
	|"implement Linked List in python"|
	|"Traversal"|
  |"Insertion"|
  |"Deletion"|
 

	
 @linkedList   
 Scenario Outline:linkedList page validation link land in correct page
    Given The user in the linkedlist page after logged in
    When The user clicks <link name> Link 
    And The user clicks  Linkedlist page Try here button
    Then The user is redirect to  linkedlist tryEditor page  
  Examples:
	 |link name|
   |"Introduction"|
   |"Creating Linked List"|
	 |"Types of Linked List"|
	 |"implement Linked List in python"|
	 |"Traversal"|
	 |"Insertion"|
	 |"Deletion"|
	
 @linkedList
 Scenario Outline:operation in Linkedlist Try Editor validation --valid scenario
		Given The user in the Linked List page after logged in
		When The user clicks Linkedlist page Try here button
		When The Linkedlist enter vaild python code print"Hello"
		And The Linkedlist clicks run button valid scenario 
		Then LinkedList is able to see the otput in console "Hello"
 Examples:
	|link name|
  |"Introduction"|
  |"Creating Linked List"|
	|"Types of Linked List"|
	|"implement Linked List in python"|
	|"Traversal"|
	|"Insertion"|
	|"Deletion"|
	
 @linkedList
 Scenario Outline: Operations in  Try Editor validation----invalid scenario
    Given The user is in the linkedList page after logged in
		When The user clicks  linkedList page Try here button
	  When The linked list user enter invalid python code" who am i"
    And The linkedlist user clicks run button and sees an alert
 Examples:
	|link name|
  |"Introduction"|
  |"Creating Linked List"|
	|"Types of Linked List"|
	|"implement Linked List in python"|
	|"Traversal"|
	|"Insertion"|
	|"Deletion"|