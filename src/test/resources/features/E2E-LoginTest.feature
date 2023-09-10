Feature: Test the login feature in flipkart

  @LoginTest
  Scenario: Login to Amazon using username and password
    Given Amazon site is launched and sign in link is clicked
    And registered email is entered
    And continue button is clicked


    @AnotherTest
    Scenario: Another Scenario
      Given another scenario