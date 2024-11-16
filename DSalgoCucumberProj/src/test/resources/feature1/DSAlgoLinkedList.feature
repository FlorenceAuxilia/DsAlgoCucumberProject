
Feature: LinkedList Page validation

 
  
  
 @linkedList   
 Scenario: Check user is redirected to Introduction of Linked List page
    Given user is on the Linked List page
    When user clicks on Introduction link
    Then user is navigated to the Introduction page
        
 @linkedList   
 Scenario: Check user is redirected to a page having TryEditor with a Run button
    Given user is on the introduction page
    When user clicks on button Try here button
    Then user is navigated to a page having TryEditor with a Run button    
 
 @linkedList   
  Scenario: Check user is redirected to of Linked List page6
    Given user is on the Linked List page
    When user clicks on Creating Linked List link
    Then user is navigated to the Creating Linked List page

 @linkedList    
  Scenario: Check user is validate to a page having TryEditor with a Run button from creating linked list page
    Given user click is on the Creating Linked List page
    When user click on button Try here button
    Then user is navigated to a page having TryEditor with a Run button
    
 @linkedList   
  Scenario: Check user is redirected to of Linked List page5
    Given user is on the Linked List page for Types
    When user clicks on Types of Linked List link
    Then user is navigated to the Types of Linked List page

 @linkedList    
  Scenario: Check user is redirected to TryEditor from Types of Linked List page
    Given user click is on the Types of Linked List page
    When user click on button the Try here button
    Then user is navigated to a page having TryEditor with a Run button for Types  
    
 @linkedList   
  Scenario: Check user is redirected to of Linked List page1
    Given User is on the Linked List page for Implement
    When User clicks on Implement of Linked List link
    Then User is navigated to the Implement of Linked List page

 @linkedList    
  Scenario: Check user is redirected to TryEditor from Implement of Linked List page
    Given User click is on the Implement of Linked List page
    When User click on button the Try here button for Implement
    Then User is navigated to a page having TryEditor with a Run button for Implement 
      
 @linkedList   
  Scenario: Check user is redirected to of Linked List page2
    Given User is on the Linked List page for Traversal
    When User clicks on Traversal of Linked List link
    Then User is navigated to the Traversal of Linked List page

 @linkedList    
  Scenario: Check user is redirected to TryEditor from Traversal of Linked List page
    Given User click is on the Traversal of Linked List page
    When User click on button the Try here button for Traversal
    Then User is navigated to a page having TryEditor with a Run button for Traversal 
 
 @linkedList   
  Scenario: Check user is redirected to of Linked List page3
    Given User is on the Linked List page for Insertion
    When User clicks on Insertion of Linked List link
    Then User is navigated to the Insertion of Linked List page

 @linkedList    
  Scenario: Check user is redirected to TryEditor from Insertion of Linked List page
    Given User click is on the Insertion of Linked List page
    When User click on button the Try here button for Insertion
    Then User is navigated to a page having TryEditor with a Run button for Insertion 
 
  @linkedList   
  Scenario: Check user is redirected to of Linked List page4
    Given User is on the Linked List page for Deletion
    When User clicks on Deletion of Linked List link
    Then User is navigated to the Deletion of Linked List page

 @linkedList    
  Scenario: Check user is redirected to TryEditor from Deletion of Linked List page
    Given User click is on the Deletion of Linked List page
    When User click on button the Try here button for Deletion
    Then User is navigated to a page having TryEditor with a Run button for Deletion 
 
