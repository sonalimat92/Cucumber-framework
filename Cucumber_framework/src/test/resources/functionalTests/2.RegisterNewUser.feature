Feature: Test Registered a new user

  @tag2
  Scenario Outline: Test Recko with Valid credentials
    When Open Chrome and Login to the Email account
    When I enter a valid credentials for gmail"<username2>" and a valid "<password2>" 
    Then I scan QR Code ,enter name"<name>",enter invalid mobile num" <invalidNum>",enter Valid mobile num"<validNum>" ,Click on Proceed"<username>" 
   
 
 Examples:   
      | username2            | password2|name|invalidNum|validNum|
      |qa-user5@recko.io|Test@5612|test|7628|8296564573|