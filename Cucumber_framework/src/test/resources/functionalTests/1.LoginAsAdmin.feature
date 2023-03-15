 @tag1
Feature: Test Login at Recko with already Registered user
 

  Scenario Outline: Test Recko with Valid credentials
    Given Open Chrome and Launch the URL
    When I enter a valid "<username1>" and a valid "<password1>"
    Then I enter QR Code and Click on Proceed for "<username1>"
    Then verify all Flows are enabled
    Then Click on Team Members and Click on Add New User
    When Enter "<name>" emailId "<emailID>" choose role "<role>" and flow "<flow>"
    Then Click on send invite
    Then User is able to Navigate to Org Settings and not able to view Internal users
    Then Back to Home
    Then Close the Browser
    
 Examples:   
      | username1       | password1  |name|emailID|role|flow|
      |qa-user2@recko.io|Test@5612|test|qa-user5@recko.io|Manager|select all|
      



      