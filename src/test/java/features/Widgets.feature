Feature: To test the functionalities of the AUT

Background: ToolsQA Demo website is launched
Given application is launched
When user clicks Widgets
Then widgets page displayed

@E2E
@Tooltips
Scenario: Test Tooltips
When user clicks Tooltips
Then tooltips page is displayed
When user hovers on button
Then button tooltip is displayed
When user hovers on textbox
Then textbox tooltip is displayed
When user hovers on text1
Then text1 tooltip is displayed
When user hovers on text2
Then text2 tooltip is displayed

  @E2E
  @SelectMenu
  Scenario: Test Select Menu
    When user clicks Select Menu
    Then select menu page is displayed
    #When user selects from first dropdown
    #Then user verifies selected option is displayed
    #When user selects from second dropdown
    #Then user verifies selected option is displayed
    When user selects from third dropdown
    Then user verifies selected option is displayed
    #When user selects from fourth dropdown
    #Then user verifies selected option is displayed
    When user selects from fifth dropdown
    Then user verifies selected option is displayed