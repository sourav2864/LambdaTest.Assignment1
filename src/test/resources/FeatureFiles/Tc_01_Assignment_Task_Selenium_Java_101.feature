#Author: Sourav Das || sourav.das@lambdaTest.com || emp_Id : XXXXXX  || Date : 19.02.2023
@123
Feature: feature to test functionality of -> Simple Form Demo | Drag & Drop Sliders | Input Form Submit [Story ID - xxxxx]
  @101
  Scenario: Simple Form Demo [Scenario ID - xxxxx]
    Given Open LambdaTest Selenium Playground from
    When Click "Simple Form Demo" under Input Forms
    Then Validate that the URL contains "simple-form-demo"
    And Create a variable for a string value "Welcome to LambdaTest"
    Then Use this variable to enter values in the “Enter Message” text box
    And Click on "Get Checked value"
    Then Validate whether the same text message is displayed in the right-hand panel under the "Your Message:" section

  @102
  Scenario: “Drag & Drop Sliders [Scenario ID - xxxxx]
    Given Open LambdaTest Selenium Playground from and click "Drag & Drop Sliders" under "Progress Bars & Sliders"
    Then Select the slider "Default value 15" and drag the bar to make it 95 by validating whether the range value shows 95

  @103
  Scenario: “Drag & Drop Sliders [Scenario ID - xxxxx]
    Given Launch LambdaTest Selenium Playground from and click "Input Form Submit" under "Input Forms"
    When Click "Submit" without filling in any information in the form
    Then Assert "Please fill in the fields" error message
    And Fill in Name, Email, and other fields
    Then From the Country drop-down, select "United States" using the text property
    And Fill all fields and click Submit
    Then Once submitted, validate the success message "Thanks for contacting us, we will get back to you shortly." on the screen