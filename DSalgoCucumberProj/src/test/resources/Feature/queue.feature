@queue
Feature: Queue page validation

Background:
Given The user is in home page with successful login

#@queue
#Scenario: Queue page validation using Get Started button
#    Given The user is in home page with successful login
#    When The user clicks the Getting Started button in Queue Panel
#    Then The user should be directed to Queue Page
# @queue   
# Scenario: Queue page validation Implementation of Queue in python link
#    Given The user is in the Queue page after logged in
#    When The user clicks "Implementation of Queue in Python" Link
#    Then The user should be directed to  "Implementation of Queue in Python" page
#
# @queue   
# Scenario: Queue page validation Implementation using collections.deque link
#    Given The user is in the Queue page after logged in
#    When The user clicks "Implementation using collections.deque" Link
#    Then The user should be directed to  "Implementation using collections.deque" page
# @queue   
# Scenario: Queue page validation Implementation using array link
#    Given The user is in the Queue page after logged in
#    When The user clicks "Implementation using array" Link
#    Then The user should be directed to  "Implementation using array" page
#  @queue   
# Scenario: Queue page validation Queue Operations link
#    Given The user is in the Queue page after logged in
#    When The user clicks "Queue Operations" Link
#    Then The user should be directed to  "Queue Operations" page 
# @queue
#  Scenario: Operations in Queue Operations Try here button validation
#    Given The user is in the Queue page after logged in
#    And The user clicks "Queue Operations" Link
#   When The user clicks  Try here button
#    Then The user is redirect to tryEditor page   
#     
#  @queue
#  Scenario: Operations in Implementation using array Try here button validation
#    Given The user is in the Queue page after logged in
#    And The user clicks "Implementation using array" Link
#   When The user clicks  Try here button
#    Then The user is redirect to tryEditor page 
#    
#    @queue
#  Scenario: Operations in Implementation using collections.deque Try here button validation
#    Given The user is in the Queue page after logged in
#    And The user clicks "Implementation using collections.deque" Link
#   When The user clicks  Try here button
#    Then The user is redirect to tryEditor page
#    
#    @queue
#  Scenario: Operations in Implementation of Queue in Python Try here button validation
#    Given The user is in the Queue page after logged in
#    And The user clicks "Implementation of Queue in Python" Link
#   When The user clicks  Try here button
#    Then The user is redirect to tryEditor page       
   
     @queue
  Scenario: Operations in stack Try Editor validation----valid scenario
    Given The user is in the Queue page after logged in
    And The user clicks "Implementation of Queue in Python" Link
   When The user clicks on Try here button
    When The user enter valid python code to print "hello"
    And The user clicks run button valid scenario
    Then User is able to see the output in console "hello"       
    