Feature: Mystore Users

  Scenario: add new address

    Given an open browser with 'https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account' and logged user
    When new address add
    Then address is added
    And close browser