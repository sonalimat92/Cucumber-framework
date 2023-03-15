#Author: bindu@recko.io

Feature: Billing info page Validation
  ​
  @Billinginfo
  Scenario Outline: Validate fields of Billing info page
    Given Navigate to Org Setting and select billing info page using credentials "<username1>" "<password1>"
    When Give invalid Pincode and Click on save "<InvalidPincode>"
    Then Verify that proper error messages should be displayed
      |pincode|
    When Give Billing address and Click on save"<Bill_add>"
    Then Verify that proper error messages should be displayed
    |Bill_add|
    When Give invalid GST Number and Click on save "<invalidGST>"
    Then Verify that proper error messages should be displayed
      | GsT    |
    When Give invalid PAN number and Click on save "<invalidPan>"
    Then Verify that proper error messages should be displayed
      | Pan    |
    When Give invalid TAN Number and Click on save "<invalidtan>"
    Then Verify that proper error messages should be displayed
      | Tan    |
    Then Provide pincode "<pincode>",Billing address "<Bill_add>",GST "<GsT>",PAN "<Pan>",TAn number"<Tan>"
    Then click on save button
    Then Verify that proper error messages should be displayed
      |NamE|
      |contact|
      |email|
    When Give Name Click on save button "<NamE>"
    Then Verify that proper error messages should be displayed
      |contact|
      |email|
    When Give invalid contact Click on save button "<invalidcontact>"
    Then Verify that proper error messages should be displayed
    |contact|
    |email|
     When Give contact Click on save button "<contact>"
    Then Verify that proper error messages should be displayed
      |email|
    When Give invalid Email id Click on save button "<invalidemail>"
    Then Verify that proper error messages should be displayed
      |email      |
    When Give Name,Contact number, Email and click on save "<NamE>" "<contact>" "<email>"
    Then Click on save button
    When Edit email and navigate to flow setting tab "<newemail>"
    Then Leave Page popup should appear and clicking on No,dont remains in same page"<action_no>"
    When Edit contact and navigate to flow setting tab "<newcontact>"
    Then Leave Page popup should appear and clicking on Yes, Leave navigates to flowsetting without saving the changes"<action_yes>"
    Then Go Back to Home and Close the Browser


    Examples:
      | username1             | password1 |pincode   |Bill_add   |GsT            |Pan       |Tan       |NamE    |contact    | email            |invalidcontact|invalidemail|InvalidPincode |invalidGST|invalidPan|invalidtan|newemail|newcontact|action_no|action_yes|
      | qa-user2@recko.io     | Test@5612 |561203   |Bengaluruu,karnataka   |22AABAB0001A2Z5|PAN|PDES03028F|Testy  | 8591210120 | test132@gmail.com     |5647|test12.com      |8             |jh32jkhr|ddsa2345   |hfsj324jk|tester21@gmail.com|9122499977|No_dont    |Yes_leave |