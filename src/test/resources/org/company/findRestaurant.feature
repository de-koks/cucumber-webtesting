Feature: find restaurant

  Scenario: select restaurant city
    Given restaurant url 'https://dodopizza.ru/'
    Then select city 'Краснодар'
    And check that selected city is 'Краснодар'

  Scenario: search absent city
    Given restaurant url 'https://dodopizza.ru/'
    Then select city 'Тбилиси'
    And message 'Пиццерия в этом городе еще не открылась' is displayed