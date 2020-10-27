Feature: To test the functionalities of the AUT

Background: ToolsQA Demo website is launched
Given application is launched
When user clicks Elements

@E2E
@BrokenImagesAndLinks
Scenario: Test broken images and links
When user clicks on Broken Links and Images
Then user verifies if image is valid
And user verifies if image is broken
And user verifies valid link
And user verifies broken link

@E2E
@Textbox
Scenario: Test JDBC via Textbox
When user clicks Textbox
Then user writes fullname

@E2E
@DownloadAndUpload
Scenario: Test uploading a file functionality
When user clicks on Upload and Download
  And user clicks on download button
  Then file is downloaded successfully
When user clicks on choose a file
And user uploads a file
Then chosen file is uploaded

  @E2E
  @Buttons
  Scenario: Test various clicking functions on buttons
    When user clicks Buttons
    Then Buttons page is displayed
    When user double cliks on button1
    Then double click message appears
    When user right clicks button2
    Then right click message appears
    When user clicks button3
    Then dynamic click message appears
