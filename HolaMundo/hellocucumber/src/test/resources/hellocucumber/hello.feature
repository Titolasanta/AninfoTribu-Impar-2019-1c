Feature: Saludar
  Prueba inicial de saludo

  Scenario Outline: Quiero saludar
    Given quiero "<saludar>"
    When diga a "<quien>" quiero saludar
    Then deberia ver "<respuesta>"

    Examples:
        | saludar           | quien           | respuesta          |
        | Hola,             | Mundo           | Hola,Mundo         |
        | Que tal,          | Cucumber        | Que tal,Cucumber   |
        | Como va,          | TP              | Como va,TP         |