# new feature
# Tags: optional
    
Feature: Creación de un riesgo
    
Scenario Outline: Crear riesgo y definir sus campos
    Given creo un riesgo nuevo
    When ingreso un "<nombre>", una <probabilidad> y un <impacto>
    And la probabilidad va entre 0.0 y 1.0
    And el impacto va entre 0.0 y 1.0
    Then ese riesgo pasa a tener ese "<nombre>", esa <probabilidad> y ese <impacto>
    And su <exposicion> debe ser el producto de la probabilidad con el impacto y se denota "<cualitativamente>"

    Examples:
        | nombre | probabilidad | impacto | exposicion | cualitativamente |
        |    A   |     0.2      |   0.5   |    0.1     |      Baja        |
        |    B   |     0.8      |   0.9   |    0.72    |      Alta        |
        |    C   |     0.5      |   0.9   |    0.45    |      Media       |
        |    D   |     0.1      |   0.0   |    0.0     |      Baja        |
        |    E   |     0.6      |   0.3   |    0.18    |      Baja        |

Scenario: Asignar un nombre
    Given creo un riesgo nuevo
    When ingreso un "<nombre>"
    Then ese riesgo pasa a tener ese "<nombre>"

Scenario: Asignar una probabilidad valida
    Given creo un riesgo nuevo
    When ingreso una probabilidad de 0.3
    Then ese riesgo pasa a tener esa probabilidad de 0.3

Scenario: Asignar una probabilidad invalida
    Given creo un riesgo nuevo
    When ingreso una probabilidad de 1.6
    Then ese riesgo no pasa a tener esa probabilidad de 1.6

Scenario: Asignar un impacto valido
    Given creo un riesgo nuevo
    When ingreso un impacto de 0.7
    Then ese riesgo pasa a tener ese impacto de 0.7

Scenario: Asignar un impacto invalido
    Given creo un riesgo nuevo
    When ingreso un impacto de -0.2
    Then ese riesgo no pasa a tener ese impacto de -0.2

Scenario: Calcular exposicion
    Given creo un riesgo nuevo
    When ingreso una probabilidad de 0.4 y un impacto de 0.3 y se calcula su exposicion
    Then ese riesgo pasa a tener 0.12 de exposicion
