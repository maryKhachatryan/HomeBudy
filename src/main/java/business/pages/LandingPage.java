package business.pages;

import business.BasePage;
import core.ActionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {
    private ActionHelper actionHelper;

    @FindBy(id = "zipCode")
    private WebElement zipCodeField;

    @FindBy(xpath = "//input[@id='zipCode']/following::button[1]")
    private WebElement getEstimateButton;

    @FindBy(xpath = "//*[@id=\'root\']/form/div/div[1]/button")
    private WebElement closeButton;

    @FindBy(xpath = "//h4[contains(text(), 'Which elements of the kitchen')]")
    private WebElement textForKitchenElements;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.actionHelper = new ActionHelper(driver);
    }

    public LandingPage enterZipCode(String zipCode) {
        waitHelper.waitUntilVisibility(zipCodeField);
        actionHelper.clear(zipCodeField);
        actionHelper.sendKeys(zipCodeField, zipCode);
        return this;
    }

    public void clickOnGetEstimateButton() {
        actionHelper.click(getEstimateButton);

    }

    public boolean getTitleForTheFirstQuestion() {
        waitHelper.waitUntilVisibility(textForKitchenElements);
        return actionHelper.isDisplayed(textForKitchenElements);
    }

    public boolean isCloseButtonDisplayed() {
        waitHelper.waitUntilVisibility(closeButton);
        return actionHelper.isDisplayed(closeButton);
    }
}
