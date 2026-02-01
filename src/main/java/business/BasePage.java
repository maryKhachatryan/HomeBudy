package business;

import core.ActionHelper;
import core.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private ActionHelper actionHelper;

    public WaitHelper waitHelper;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver, 30);
        this.actionHelper = new ActionHelper(waitHelper);
    }

}
