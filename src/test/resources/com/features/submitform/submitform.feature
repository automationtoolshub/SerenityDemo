Feature: Validate User Form

  Scenario Outline: User able to Submit Tell us YourSelf Form successfully
    Given Open the application
    And fill the following user information "<address>","<city>","<state>","<zipCode>","<email>","<pboneNumber>","<dob>"
    And submit the form
    Then verify user is navigated to summaryPage
    And click Continue button in the summaryPage
    Then verify user is navigated to successPage

    Examples: 
      | address      | city    | state | zipCode | email          | pboneNumber | dob        |
      | 758 Lakeview,1A | Chicago | IL    |   60090 | test1@gmai.com |  8474141830 | 12-01-1990 |
      | 1405 Fairway,2B | Raligh  | NC    |   27616 | test2@gmai.com |  8474141831 | 01-01-1995 |
