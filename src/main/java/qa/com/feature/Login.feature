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
    |BVO|*****|
    
  @Invalid 
  Scenario Outline: Error message for invalid username
   When user enters "<username>" and "<password>"
   And Clicks on login button
   Then error message User not exist is displaying
   
   Examples:
   |username|password|
   |rakesh|*****|
   
  @loggedinuser
  Scenario Outline: Logged in user error message
   When user enters "<username>" and "<password>"
   And Clicks on login button
   Then error message User already logged in is displaying
   
   Examples:
   |username|password|
   |Credit1|*****|
  
  
  
