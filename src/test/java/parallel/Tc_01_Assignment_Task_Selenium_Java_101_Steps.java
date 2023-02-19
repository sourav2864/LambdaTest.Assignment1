package parallel;

import com.pages.SimpleFormDemoPage;
import com.pages.dragDropRangeSlidersDemoPage;
import com.pages.inputFormSubmitPage;
import com.pages.playgroundPage;
import io.cucumber.java.en.*;

import java.io.IOException;

public class Tc_01_Assignment_Task_Selenium_Java_101_Steps {
    playgroundPage pgp = new playgroundPage();
    SimpleFormDemoPage sfp = new SimpleFormDemoPage();
    inputFormSubmitPage ifsp = new inputFormSubmitPage();

    dragDropRangeSlidersDemoPage ddrs = new dragDropRangeSlidersDemoPage();

    @Given("Open LambdaTest Selenium Playground from")
    public void open_lambda_test_selenium_playground_from() throws IOException {
        pgp.open_lambda_test_selenium_playground_from();
    }

    @When("Click {string} under Input Forms")
    public void clickUnderInputForms(String sfd) throws IOException {
        pgp.clickUnderInputForms(sfd);
    }

    @Then("Validate that the URL contains {string}")
    public void validateThatTheURLContains(String partialURL) throws IOException {
        sfp.validateThatTheURLContains(partialURL);
    }

    @And("Create a variable for a string value {string}")
    public void createAVariableForAStringValue(String WelcomeLambdaTest) {
        sfp.createAVariableForAStringValue(WelcomeLambdaTest);
    }

    @Then("Use this variable to enter values in the “Enter Message” text box")
    public void useThisVariableToEnterValuesInTheEnterMessageTextBox() {
        sfp.useThisVariableToEnterValuesInTheEnterMessageTextBox();
    }

    @And("Click on {string}")
    public void clickOnGetCheckedValue(String get) {
        sfp.clickOnGetCheckedValue(get);
    }

    @Then("Validate whether the same text message is displayed in the right-hand panel under the {string} section")
    public void validateWhetherTheSameTextMessageIsDisplayedInTheRightHandPanelUnderTheSection(String yourMsgSectionName) {
        sfp.validateWhetherTheSameTextMessageIsDisplayedInTheRightHandPanelUnderTheSection(yourMsgSectionName);
    }

    @Given("Open LambdaTest Selenium Playground from and click {string} under {string}")
    public void openLambdaTestSeleniumPlaygroundFromAndClickUnder(String drDpSlide, String proBarSlide) throws IOException {
        pgp.openLambdaTestSeleniumPlaygroundFromAndClickUnder(drDpSlide,proBarSlide);
    }

    @Then("Select the slider {string} and drag the bar to make it {int} by validating whether the range value shows {int}")
    public void selectTheSliderAndDragTheBarToMakeItByValidatingWhetherTheRangeValueShows(String defaultValue15, int inputValue, int outputValue) throws IOException {
        ddrs.selectTheSliderAndDragTheBarToMakeItByValidatingWhetherTheRangeValueShows(defaultValue15,inputValue,outputValue);
    }

    @Given("Launch LambdaTest Selenium Playground from and click {string} under {string}")
    public void launchLambdaTestSeleniumPlaygroundFromAndClickUnder(String inputFormSubmit, String inputForms) throws IOException {
        pgp.launchLambdaTestSeleniumPlaygroundFromAndClickUnder(inputFormSubmit,inputForms);
    }

    @When("Click {string} without filling in any information in the form")
    public void clickWithoutFillingInAnyInformationInTheForm(String submit) throws IOException {
        ifsp.clickWithoutFillingInAnyInformationInTheForm(submit);
    }

    @Then("Assert {string} error message")
    public void assertErrorMessage(String errorMsg) {
        ifsp.assertErrorMessage(errorMsg);
    }

    @And("Fill in Name, Email, and other fields")
    public void fillInNameEmailAndOtherFields() throws IOException {
        ifsp.fillInNameEmailAndOtherFields();
    }

    @Then("From the Country drop-down, select {string} using the text property")
    public void fromTheCountryDropDownSelectUsingTheTextProperty(String countryName) {
        ifsp.fromTheCountryDropDownSelectUsingTheTextProperty(countryName);
    }

    @And("Fill all fields and click Submit")
    public void fillAllFieldsAndClickSubmitButton() {
        ifsp.fillAllFieldsAndClickSubmitButton();
    }


    @Then("Once submitted, validate the success message {string} on the screen")
    public void onceSubmittedValidateTheSuccessMessageOnTheScreen(String successMsg) {
        ifsp.onceSubmittedValidateTheSuccessMessageOnTheScreen(successMsg);
    }
}
