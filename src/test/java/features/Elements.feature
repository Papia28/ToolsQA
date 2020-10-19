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
@Upload
Scenario: Test the uploading a file functionality
Then user clicks on Upload and Download
And user clicks on choose a file
And user uploads a file
And chosen file is uploaded