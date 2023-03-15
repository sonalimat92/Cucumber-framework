
Feature: Test already Registered user as a Internal user at Recko 

  @tag4
 Scenario Outline: Test Recko with Valid credentials having access to D flow
     Given Open Chrome and Launch the URL
    When I enter a valid "<username6>" and a valid "<password6>"
    Then I enter QR Code and Click on Proceed for "<username6>"
    Then verify all Flows are enabled
    And User is able to Navigate to Org Settings and able to view all users
   Then Back to Home
    Then Close the Browser
 Examples:   
       | username6       | password6  |
      |qa-user1@recko.io|Test@5612|