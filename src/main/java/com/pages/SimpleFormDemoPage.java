package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class SimpleFormDemoPage extends ElementUtil {
    String welcomeMsg = null;

    public SimpleFormDemoPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='user-message']")
    private WebElement enter_Message_InputBox;
    @FindBy(xpath = "//button[@id='showInput']")
    private WebElement getCheckedValueButton;

    @FindBy(xpath = "//h2[contains(text(),'your first example')]")
    private WebElement h2Heading;

    @FindBy(xpath = "//div[@id='user-message']//label[contains(text(),'Message')]")
    private WebElement yourMsgSection;

    @FindBy(xpath = "//div[@id='user-message']//p[@id='message']")
    private WebElement yourMsgActualValue;

    public void validateThatTheURLContains(String partialURL) {
        waitForElementDisplayed(h2Heading);
        scrollToElement(h2Heading);
        waitForElementDisplayed(enter_Message_InputBox);
        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl()
                        .contains(partialURL),
                "contains URL of Simple Form Demo page didn't match");
    }

    public void createAVariableForAStringValue(String WelcomeLambdaTest) {
        welcomeMsg = WelcomeLambdaTest;
        Assert.assertTrue(welcomeMsg.equals(WelcomeLambdaTest),
                "Variable creation for a string value \"Welcome to LambdaTest\" is Unsuccessful");
    }

    public void useThisVariableToEnterValuesInTheEnterMessageTextBox() {
        enter_Message_InputBox.sendKeys(welcomeMsg);
    }

    public void clickOnGetCheckedValue(String get) {
        Assert.assertTrue(getCheckedValueButton.getText().trim().equals(get)
        ,"Get checked value button text didn't match");
        clickOnWebElement(getCheckedValueButton);
    }

    public void validateWhetherTheSameTextMessageIsDisplayedInTheRightHandPanelUnderTheSection(String yourMsgSectionName) {
        Assert.assertTrue(yourMsgSection.getText().trim().contains(yourMsgSectionName),
                "Your Message section's text name is not match");
        waitForElementDisplayed(yourMsgActualValue);
        Assert.assertTrue(yourMsgActualValue.getText().trim().equals(welcomeMsg),
                "Validation of text message is Unsuccessful");
    }
}
