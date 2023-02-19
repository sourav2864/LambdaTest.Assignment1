package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class dragDropRangeSlidersDemoPage extends ElementUtil {
    public dragDropRangeSlidersDemoPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(xpath = "//h2[contains(text(),'Range Sliders')]")
    private WebElement h2Heading;
    @FindBy(xpath = "//h4[contains(text(),' Default value 15')]")
    private WebElement defaultValue15_Text;
    @FindBy(xpath = "//h4[contains(text(),' Default value 15')]/following-sibling::div//input")
    private WebElement defaultValue15_Input;
    @FindBy(xpath = "//h4[contains(text(),' Default value 15')]/following-sibling::div//output")
    private WebElement defaultValue15_output;

    public void selectTheSliderAndDragTheBarToMakeItByValidatingWhetherTheRangeValueShows(String defaultValue15, int inputValue, int outputValue) throws IOException {
        waitForElementDisplayed(h2Heading);
        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl()
                .contains(ConfigReader.getData("dragDrop_Partial_URL")),"Drag and Drop URL didn't match");
        scrollToElement(h2Heading);
        Assert.assertTrue(defaultValue15_Text.getText().trim().equals(defaultValue15),"default Value 15 text didn't match");
        ((JavascriptExecutor) DriverFactory.getDriver())
                .executeScript("setAttribute('value','"+inputValue+"');",defaultValue15_Input);
        waitFor(2500);
        Assert.assertTrue(defaultValue15_output.getText().trim().equals(outputValue),
                "drag and drop validations is failed");
    }
}
