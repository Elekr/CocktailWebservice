Feature: Access the database
          AS A heavy drinker with a problem
          I WANT TO be able to look at cocktail recipes
          SO THAT I can look at how to make a drink to get absolutely blackout

  Scenario: Successfully access cocktail database

    Given The website is currently running
    When I try to look up the drink I want "Mojito"
    Then The database will retrieve the cocktail I want
    And I will have all the information about a "Mojito"

