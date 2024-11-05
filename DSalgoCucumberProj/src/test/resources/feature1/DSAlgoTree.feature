@tree
Feature: Tree page validation

#Background:
#Given The user is in home page after successful login

@tree
Scenario: Tree page validation using Get Started button
  When The user clicks the Getting Started button in Tree Panel
    Then The user should be directed to Tree Page


 @tree   
 Scenario Outline:Tree page validation link land in correct page
    Given The user in the Tree page after logged in
    When The user clicks <link name> Link in treepage
    Then The user to be directed to  <link name> page

Examples:
	|link name|
	|"Overview of Trees"|
	|"Terminologies"|
	|"Types of Trees"|
	|"Tree Traversals"|
	|"Traversals-Illustration"|
	|"Binary Trees"|
	|"Types of Binary Trees"|
	|"Implementation in Python"|
	|"Binary Tree Traversals"|
	|"Implementation of Binary Trees"|
	|"Applications of Binary trees"|
	|"Binary Search Trees"|
	|"Implementation Of BST"| 

 @tree   
 Scenario Outline:Tree page practice Ques validation link land in correct page
    Given The user in the Tree page after logged in
    When The user clicks <link name> Link in treepage
    And The user clicks "Practice Questions" Link in treepage
    Then The Practice question for tree page should be displayed
	
	Examples:
	|link name|
	|"Overview of Trees"|
	|"Terminologies"|
	|"Types of Trees"|
	|"Tree Traversals"|
	|"Traversals-Illustration"|
	|"Binary Trees"|
	|"Types of Binary Trees"|
	|"Implementation in Python"|
	|"Binary Tree Traversals"|
	|"Implementation of Binary Trees"|
	|"Applications of Binary trees"|
	|"Binary Search Trees"|
	|"Implementation Of BST"| 

	
	
	@tree
	Scenario Outline:Tree page Try here button validation
    Given The user in the Tree page after logged in
    And The user clicks <link name> Link in treepage
   When The user clicks Tree page Try here button
    Then The user is redirect to Tree page tryEditor page  
Examples:
	|link name|
	|"Overview of Trees"|
	|"Terminologies"|
	|"Types of Trees"|
	|"Tree Traversals"|
	|"Traversals-Illustration"|
	|"Binary Trees"|
	|"Types of Binary Trees"|
	|"Implementation in Python"|
	|"Binary Tree Traversals"|
	|"Implementation of Binary Trees"|
	|"Applications of Binary trees"|
	|"Binary Search Trees"|
	|"Implementation Of BST"| 
