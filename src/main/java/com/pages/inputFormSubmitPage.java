package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class inputFormSubmitPage extends ElementUtil {
    public inputFormSubmitPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@class='sp__breadcrumb']")
    private WebElement breadcrumb;
    @FindBy(xpath = "//form[@id='seleniumform']//button[@type='submit']")
    private WebElement submitBtn;
    @FindBy(xpath = "//form[@id='seleniumform']//input[@id='name']")
    private WebElement nameInputBox;
    @FindBy(xpath = "//form[@id='seleniumform']//input[@name='email']")
    private WebElement emailInputBox;
    @FindBy(xpath = "//form[@id='seleniumform']//input[@name='password']")
    private WebElement passwordInputBox;
    @FindBy(xpath = "//form[@id='seleniumform']//input[@name='company']")
    private WebElement companyInputBox;
    @FindBy(xpath = "//form[@id='seleniumform']//input[@name='website']")
    private WebElement websiteInputBox;
    @FindBy(xpath = "//form[@id='seleniumform']//input[@name='city']")
    private WebElement cityInputBox;
    @FindBy(xpath = "//form[@id='seleniumform']//input[@name='address_line1']")
    private WebElement address_line1_InputBox;
    @FindBy(xpath = "//form[@id='seleniumform']//input[@name='address_line2']")
    private WebElement address_line2_InputBox;
    @FindBy(xpath = "//form[@id='seleniumform']//input[@id='inputState']")
    private WebElement stateInputBox;
    @FindBy(xpath = "//form[@id='seleniumform']//input[@id='inputZip']")
    private WebElement zipInputBox;

    @FindBy(xpath = "//select[@name='country']")
    private WebElement countryDropDown;

    @FindBy(xpath = "//p[@class='success-msg hidden']")
    private WebElement successMsg;

    public void clickWithoutFillingInAnyInformationInTheForm(String submit) throws IOException {
        waitForElementDisplayed(breadcrumb);
        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains(ConfigReader.getData("input_form_Partial_URL")));
        scrollToElement(breadcrumb);
        Assert.assertTrue(submitBtn.getText().trim().equals(submit));
        clickOnWebElement(submitBtn);
    }

    public void assertErrorMessage(String errorMsg) {
//        waitFor(2000);
//        Alert alert = DriverFactory.getDriver().switchTo().alert();
//        System.out.println(alert.getText());
    }

    public void fillInNameEmailAndOtherFields() throws IOException {
        nameInputBox.sendKeys(ConfigReader.getData("nameInputBox"));
        emailInputBox.sendKeys(ConfigReader.getData("emailInputBox"));
        passwordInputBox.sendKeys(ConfigReader.getData("passwordInputBox"));
        companyInputBox.sendKeys(ConfigReader.getData("companyInputBox"));
        websiteInputBox.sendKeys(ConfigReader.getData("websiteInputBox"));
        cityInputBox.sendKeys(ConfigReader.getData("cityInputBox"));
        address_line1_InputBox.sendKeys(ConfigReader.getData("address_line1_InputBox"));
        address_line2_InputBox.sendKeys(ConfigReader.getData("address_line2_InputBox"));
        stateInputBox.sendKeys(ConfigReader.getData("stateInputBox"));
        zipInputBox.sendKeys(ConfigReader.getData("zipInputBox"));
    }

    public void fromTheCountryDropDownSelectUsingTheTextProperty(String countryName) {
        selectFromDropDown(countryDropDown, countryName);
    }
    public void fillAllFieldsAndClickSubmitButton() {
        clickOnWebElement(submitBtn);
    }
    public void onceSubmittedValidateTheSuccessMessageOnTheScreen(String successMsgText) {
        waitFor(1500);
        waitForElementDisplayed(successMsg);
        Assert.assertTrue(successMsg.getText().equals(successMsgText),
                "Success message validation is Unsuccessful");
    }
}
