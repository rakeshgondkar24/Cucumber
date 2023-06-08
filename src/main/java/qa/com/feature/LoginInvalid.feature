Feature: new feature file
  Background: 
      Given the users launch the browser and loads Fedmithra web app


  @Invaliddata
  Scenario Outline: Error scenario
    When user enters "<username>" and "<password>"
    And Clicks on login button
   Then error message User not exist is displaying
   
   Examples:
    |username|password|
   	|rakesh|Federal@123|