Feature: login feature of fedmithra application
  I want to use this template for my feature file
  Background: 
      Given the users launch the browser and loads Fedmithra web app
  
  
  @validdata
  Scenario Outline: Login to Application using Valid Credential
    When user enters "<username>" and "<password>"
    And Clicks on login button
    Then home page is getting redirected
    
    Examples:
    |username|password|
    |Credit1|Federal@123|
    
  @invaliddata
  Scenario Outline: Error message for invalid data
    When user enters "<username>" and "<password>"
    And Clicks on login button
    Then Error message should display
    
    Examples: 
    |username|password|
    |Credit|Federal@123|
    