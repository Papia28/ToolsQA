Feature: Test the drag and drop functionality

Background: ToolsQA Demo website is launched
Given application is launched
When user clicks Interactions
  Then Interactions page is displayed

@E2E
@DragAndDrop
Scenario: Test dragging and dropping of items
When user selects Droppable
  Then Droppable page is displayed
And user drags and drops item
Then text changes

@DragAndDropRobot
Scenario: Test dragging and dropping of items using Robot class functions
When user clicks Interactions using Robot
Then Interactions page opens using Robot
When user selects Droppable using Robot
And user drags and drops item using Robot
Then text changes using Robot


  @Resizing
  Scenario: Test resizing of items
    When user selects Resizable
    Then Resizable page is displayed
    And user drags and resizes item1
    And user drags and resizes item2