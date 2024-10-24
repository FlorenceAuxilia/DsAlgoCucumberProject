Feature: Stack page validation

 @test
  Scenario: Stack page validation using Get Started button
    Given The user is in home page with successful login
    When The user clicks the Getting Started button in Stack Panel
    Then The user should be directed to "Stack" Page
@test
  Scenario: Stack page validation using stack dropdown option
    Given The user is in home page with successful login
    When The user clicks Stack option in the dropdown
    Then The user should be directed to "Stack" Page
@test
  Scenario: Operations in stack link validation
    Given The user clicks Stack option in the dropdown
    When The user clicks Operations in stack link
    Then The user should be directed to operations in stack page "Operations in Stack"
@test
  Scenario: Operations in stack Try here button validation
    Given The user clicks Stack option in the dropdown
    And The user clicks Operations in stack link
    When The user clicks on Try here button
    Then The user redirect to tryEditor page
@test
  Scenario: Operations in stack Try Editor validation----valid scenario
    Given The user clicks Stack option in the dropdown
    And The user clicks Operations in stack link
    And The user clicks on Try here button
    When The user enter valid python code to print "hello"
    And The user clicks run button valid scenario
    Then User is able to see the output in console "hello"
@test
  Scenario: Operations in stack Try Editor validation---Invalid scenario with popup handling
    Given The user clicks Stack option in the dropdown
    And The user clicks Operations in stack link
    And The user clicks on Try here button
    When The user enter Invalid python code to print "hi"
    And popup handle
@test
  Scenario: Implementation link validation
    Given The user clicks Stack option in the dropdown
    When The user clicks Implementation link
    Then The user should be directed to implementation page "Implementation"
@test
  Scenario: Implementation Try here button validation
    Given The user clicks Stack option in the dropdown
    And The user clicks Implementation link
    When The user clicks on Try here button
    Then The user redirect to tryEditor page
@test
  Scenario: Implementation Try Editor validation----valid scenario
    Given The user clicks Stack option in the dropdown
    And The user clicks Implementation link
    And The user clicks on Try here button
    When The user enter valid python code to print "hello"
    And The user clicks run button valid scenario
    Then User is able to see the output in console "hello"
@test
  Scenario: Implementation Try Editor validation---Invalid scenario with popup handling
    Given The user clicks Stack option in the dropdown
    And The user clicks Implementation link
    And The user clicks on Try here button
    When The user enter Invalid python code to print "hi"
    Then popup handle
@test
  Scenario: Applications link validation
    Given The user clicks Stack option in the dropdown
    When The user clicks Applications link
    Then The user should be directed to Applications page "Applications"
@test
  Scenario: Applications Try here button validation
    Given The user clicks Stack option in the dropdown
    And The user clicks Applications link
    When The user clicks on Try here button
    Then The user redirect to tryEditor page
@test
  Scenario: Applications Try Editor validation----valid scenario
    Given The user clicks Stack option in the dropdown
    And The user clicks Applications link
    And The user clicks on Try here button
    When The user enter valid python code to print "hello"
    And The user clicks run button valid scenario
    Then User is able to see the output in console "hello"
@test
  Scenario: Applications Try Editor validation---Invalid scenario with popup handling
    Given The user clicks Stack option in the dropdown
    And The user clicks Applications link
    And The user clicks on Try here button
    When The user enter Invalid python code to print "hi"
    And popup handle
@test
  Scenario: Practice Questions link validation
    Given The user clicks Stack option in the dropdown
    And The user clicks Applications link
    When The user clicks Practice Questions link
    Then The user should redirect to Practice Questions page
