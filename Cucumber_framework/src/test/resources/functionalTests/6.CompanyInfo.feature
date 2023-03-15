#Author: sonali@recko.io
@CompanyInfo
Feature: Company Info

  Scenario Outline: 1.Validate Mandatory fiels
    Given Navigate to Org Setting and select flow page using credentials "<username>" "<password>"
    When Give Registered name and Click on save "<Name>"
    Then Verify that proper error message should be displayed
      | name    |
      | contact |
      | email   |
    When Upload  logo and Click on save "<logo1>"
    Then Verify that proper error message should be displayed
      | name    |
      | contact |
      | email   |
    When Give Organization Website and click on save"<Website>"
    When Click change logo  to upload logo
    Then Verify clicking on change logo ,can select image and upload
    When should allow .gif, .jpg, .png images to upload
    And Should not allow .doc, .pdf and .xlsx files
    When Click on cross icon present on  logo to remove the logo
    Then Verify that clicking on cross icon, logo should be removed
    When Upload  logo and Click on save "<logo1>"
    When Provide name "<Name>" and Click on save
    Then Verify that proper error message should be displayed
      | contact |
      | email   |
    When Provide contact and Click on Flow Settings tab ,Validate the Leave Block Click on Yes , Navigate back to Company Info contact should not be saved
    When Provide name "<Name>" and contact num "<contact>" and Click on save
    Then Verify that proper error message should be displayed
      | email |
    When Provide name "<Name>" and email id "<email>" and click on save
    Then Verify that proper error message should be displayed
      | contact |
    When Provide name "<Name>" ,email id "<email>" and provide less than ten digit in contact details filed "<invalidContact>" and Click on save
    Then Verify that proper error message should be displayed
      | contact |
    When Provide name "<Name>", contact number "<contact>" and invalid email id "<invalidEmail>" and Click on save
    Then Verify that proper error message should be displayed
      | email |
    When Provide Name "<Name>", contact number "<contact>" and email "<email>" and clicking on save
    Then Verify that clicking on save should save the contact person details
    When Click on Add another contact
    Then Verify name ,contact num, email id filed form should display
    When Click on add another contact multiple times
    Then Verify multiple form should display
    When Click on Add another contact multiple times and Click on save without filling the fields
    Then Verify should show invalid fileds error message
    When Click on cross icon present at the top right corner of each contact detail form
    Then Verify that Clicking on cross icon ,deletes(removes)  the contact data of that particular form
    Then Back to Home and Close the Browser

    Examples: 
      | username               | password  | Name | logo1 | Website      | contact    | email          | invalidContact | invalidEmail |
       |qa-user1@recko.io|Test@5612|test|test| www.test.com | 8071000012 | test@gmail.com |         182819 | test.com     |
