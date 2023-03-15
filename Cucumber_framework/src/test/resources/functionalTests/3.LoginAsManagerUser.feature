
Feature: Test Registered user as a Manager at Recko 

 @tag3
 Scenario Outline: Test Recko with Valid credentials having access to D flow
    Given Open Chrome and Launch the URL
    When I enter a valid "<username3>" and a valid "<password3>"
    Then I enter QR Code and Click on Proceed for "<username3>"
    Then verify only D Flow is enabled
    Then Close the Browser

  
 Examples:   
      | username3       | password3  |
      |qa-user3@recko.io|Test@5612|