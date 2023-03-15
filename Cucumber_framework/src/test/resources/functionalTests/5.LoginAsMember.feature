Feature: Test already Registered user as a Member at Recko 

@tag5
  Scenario Outline: Test Login as a member with access to C Flow
    Given Open Chrome and Launch the URL
    When I enter a valid "<username4>" and a valid "<password4>"
    Then I enter QR Code and Click on Proceed for "<username4>"
    Then verify only C Flow is enabled
    Then Close the Browser
    
 Examples:   
      | username4       | password4  |
      |qa-user4@recko.io |Test@5612|
      
