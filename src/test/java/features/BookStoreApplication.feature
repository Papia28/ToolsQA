#Author: Papia Nandi

Feature: To test ToolsQADemo Book Store Application

@E2E
@Login
Scenario Outline: To validate Login functionality
Given application is launched
When user clicks Book Store Application
And user clicks Login 
Then user provides "<Username>" and "<Password>"
And user clicks Login again
Then user successfully logs into Book Store

Examples:
|Username	|Password				|
|Papia28	|Papia@28Tools	|

#Then provide "Username" and "Password"    #This is without using examples keyword