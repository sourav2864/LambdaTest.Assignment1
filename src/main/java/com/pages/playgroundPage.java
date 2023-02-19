package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;


public class playgroundPage extends ElementUtil {
    public playgroundPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Simple Form Demo']")
    private WebElement simple_Form_Demo_CTA;

    @FindBy(xpath = "//h2[@class='st_heading' and contains(text(),'Progress Bars & Sliders')]")
    private WebElement progress_Bars_SlidersSection;

    @FindBy(xpath = "//a[text()='Drag & Drop Sliders']")
    private WebElement drag_DropSliders_CTA;

    @FindBy(xpath = "//a[text()='Input Form Submit']")
    private WebElement input_Form_Submit_CTA;

    @FindBy(xpath = "//h2[@class='st_heading' and contains(text(),'Input Forms')]")
    private WebElement input_Forms_SlidersSection;

    public void open_lambda_test_selenium_playground_from() throws IOException {
        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl()
                .equals(ConfigReader.getData("appUrl")), "URL didn't match");
    }

    public void clickUnderInputForms(String sfd) throws IOException {
        waitForElementDisplayed(simple_Form_Demo_CTA);
        waitForElementClickable(simple_Form_Demo_CTA);
        Assert.assertTrue(simple_Form_Demo_CTA.getText().trim()
                .equals(ConfigReader.getData("simple_Form_Demo_CTA_Text")), "simple Form Demo CTA text didn't match");
        clickOnWebElement(simple_Form_Demo_CTA);
    }

    public void openLambdaTestSeleniumPlaygroundFromAndClickUnder(String drDpSlide, String proBarSlide) throws IOException {
        waitForElementDisplayed(simple_Form_Demo_CTA);
        waitForElementClickable(simple_Form_Demo_CTA);
        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl()
                .equals(ConfigReader.getData("appUrl")), "URL didn't match");
        scrollToElement(simple_Form_Demo_CTA);
        Assert.assertTrue(drag_DropSliders_CTA.getText().equals(drDpSlide),
                "Drag & Drop Sliders text is not match");
        Assert.assertTrue(progress_Bars_SlidersSection.getText().equals(proBarSlide),
                "Progress Bars & Sliders text is not match");
        clickOnWebElement(drag_DropSliders_CTA);
    }

    public void launchLambdaTestSeleniumPlaygroundFromAndClickUnder(String inputFormSubmit, String inputForms) throws IOException {
        waitForElementDisplayed(simple_Form_Demo_CTA);
        waitForElementClickable(simple_Form_Demo_CTA);
        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl()
                .equals(ConfigReader.getData("appUrl")), "URL didn't match");
        scrollToElement(simple_Form_Demo_CTA);
        Assert.assertTrue(input_Form_Submit_CTA.getText().equals(inputFormSubmit),
                "input Form submit text is not match");
        Assert.assertTrue(input_Forms_SlidersSection.getText().equals(inputForms),
                "Progress Bars & Sliders text is not match");
        clickOnWebElement(input_Form_Submit_CTA);
    }


}
