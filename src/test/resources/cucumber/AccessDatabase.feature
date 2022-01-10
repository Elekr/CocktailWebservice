Feature: Access the database
          AS A heavy drinker with a problem
          I WANT TO be able to look at cocktail recipes
          SO THAT I can look at how to make a drink to get absolutely blackout

  Scenario: Successfully access cocktail database
    Given The website is currently running
    When I try to look up the drink I want "Mojito"
    Then The database will retrieve the cocktail I want
    And I will have all the information about a "Mojito"

  Scenario: The website goes to the wrong route
    Given The website is running but goes to the wrong route
    Then I won't be able to access the website

  Scenario: The drink I want does not exist
    Given The website is currently running up
    When I try to look up the drink that I want "appletini"
    And The drink does not exist
    Then The database will return that the drink does not exist
