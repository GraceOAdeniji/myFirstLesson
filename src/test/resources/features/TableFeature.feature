Feature: Table test
  Scenario: My first table test
    Given student record exists
    Then Verify that  record entered is correct
    | Lastname | Firstname| Age | Gender| DOB        |
    | Adeniji  | Olusegun | 15  | Male  | 11-01-2006 |
    | Olubunmi | Grace    | 17  | Female| 11-01-2003 |
    | Nathan   | King     | 10  | Male  | 11-01-2004 |
    | John     | Lizzy    | 10  | Male  | 11-01-2004 |