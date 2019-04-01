Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario Outline: Today is or is not Friday
    Given i say "<saludo>"
    When I ask what answer i get
    Then I should be told "<answer>"

  Examples:
    | saludo       | answer |
    | Hola         | Hola mundo!   |