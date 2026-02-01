package business;

import core.ActionHelper;
import core.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private ActionHelper actionHelper;

    public WaitHelper waitHelper;
    @FindBy(xpath = "//a[@href = '/sign-in']")
    private WebElement signInToValueClubButton;

    private final String PATH = "account";

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver, 30);
        this.actionHelper = new ActionHelper(waitHelper);
    }
    public String getAccountHomePagePath(){
        return PATH;
    }

    public void clickOnSignInToValueClubButton(){
        actionHelper.click(signInToValueClubButton);
    }

    //other way for checking if the user is on login page
    public boolean isOnPage(WebElement element){
        return element.isDisplayed();
    }
}
