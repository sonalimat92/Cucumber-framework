@Dashboard
Feature: DashBoard
  


  Scenario Outline: Dashboard alerts and graphs 
    Given Navigate to Dashboard using credentials "<username>" "<password>"
    Then Validate that Dashboard analytics is displayed as header 
    And Validate Load button is displayed
    When Last updated date is displayed 
    Then Verifying different sections on the page should be displayed - Reconciliation status, Ageing Summary, Rate percentage overtime and Alerts
    Then Transaction type, party, and date range should be present for Reconciliation status and Ageing summary
    When Apply filter for transaction type 
    |Reconciliation Status|
    |Reverse|
    Then Verify Clear button should be enabled
    |Reconciliation Status|
    When Click on clear button,button should be disabled now
    |Reconciliation Status|
    Then Settled  ,Open ,In Process and Foreign tabs are displayed with the type of filter selected
    Then Validate that Download button is displayed with Csv and Png as available option.
    |Reconciliation Status| 
    When Click on Bucket tab ,Graph title should change repectively 
    |In Process|
    Then Party wise ageing summary title,Total transaction amount settled after SLA day and Transaction amount settled by PGs after SLA day should be displayed
     When Apply filter for transaction type 
    |Ageing Summary|
    |Reverse|
    Then Verify Clear button should be enabled
    |Ageing Summary|
    When Click on clear button,button should be disabled now
    |Ageing Summary|
    Then Validate party,choose instruments and date range should be present for Rate pecrentage overtime
    Then Validate Rate % for all PGs,Amount Volume for all instruments for PGs,Movement in PG's Rate % and Instruments for all PGs should be displayed
    When Verify if no data is present Download csv report should be disabled.
    When Verify If a Bucket amount is zero in Reconcilation status , no chart should be displayed
    When Verify Total Transaction amount should be displayed in Party wise ageing Summary for each party
    When Verify Hover over on total amount displays complete amount in a pop up
    When Verify Each cell in chart should have settled percentage displayed and the amount should be displayed when hover overed on it.
    Then Total amount should be equal to the sum of each cell settlement amount
    Then Download CSV report 
    Then Verify that  amount in Report is same as amount displayed on Dashboard
    When Choose a PG 
    |PAYU|
    |Rate % Overtime|
    Then Rate % ,Movement in PG's Rate,Amount in volume and Instruments should be displayed only for that PG
    |PAYU|
    When Choose intruments from filter
    |Credit Card|
    Then Validate that only selected instruments are displayed in Instrument for all PG's chart
    |Credit Card|
    When Choose a PG  
    |AXIS|
    |Reconciliation Status|
    Then Validate that only selected PG's chart is displayed and amount displayed in bucket and chart is same
    |AXIS|
    When Alerts is displayed with the count and Show all button
    Then Print all alerts displayed
    When Alert is closed ,Validate Count is decreased,Click on Show All and All the alerts should be displayed again
    When Click on Alerts and Validate the headers and the format of data
    Then Logout from the session
      Examples: 
   | username               | password  |
      | qa-user1@recko.io | Test@5612 | 


