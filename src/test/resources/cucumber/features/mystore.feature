Feature: Mystore Users

  Scenario Outline: add new address

    Given an open browser with 'https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account' and logged user
    When user type <alias>, <address>, <city>, <zip>, <phone> in the new addresses form
    Then address with alias: <alias> is added
    And clean up and close browser


    Examples:
      | alias  | address    | city     | zip    | phone     |
      | dom    | Polna 23   | Warszawa | 02-887 | 123456789 |
      | praca  | Dolna 15   | Warszawa | 02-889 | 987654321 |
