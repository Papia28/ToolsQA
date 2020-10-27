#Author: Papia Nandi

Feature: To test SeleniumEasy Demo Application Web Tables

@E2E
@WebTables1
Scenario Outline: To validate dynamic web tables
Given SeleniumEasy Demo Application is launched
When user enters given "<Position>" in searchbox
Then user finds information for given "<Age>"
And user displays the information

Examples:
|Position	|Age  |
|Engineer   |25	  |
|Developer  |30	  |

#Then provide "Username" and "Password"    #This is without using examples keyword

  @E2E
    @WebTables2
  Scenario Outline: To validate dynamic web tables
    Given SeleniumEasy Demo Application is launched
    When user enters given "<Location>" in searchbox
    Then user finds information for given "<Age>"
    And user displays the information

    Examples:
      |Location	  |Age    |
      |London     |50	  |
      |New York   |25	  |

  @E2E
    @WebTables3
  Scenario Outline: To validate dynamic web tables
    Given SeleniumEasy Demo Application is launched
    Then user finds information for given "<Age>"
    And user displays the information

    Examples:
      |Age    |
      |40	  |
      |60	  |