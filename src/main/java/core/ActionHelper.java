package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class ActionHelper {

    private WaitHelper waitHelper;

    public ActionHelper(WaitHelper waitHelper) {
        this.waitHelper = waitHelper;
    }

    /**
     *
     * @param element instead of element will be errorMessage
     * @return
     */
    public boolean isDisplayed(WebElement element){
        waitHelper.waitUntilVisibility(element);
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void scrollTo(WebDriver driver) throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,350)", "");
    }

    public void scrollDown(WebDriver driver, int pixel) throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(String.format("window.scrollBy(0, %s)", pixel), "");
    }

    private static Select select;

    public void click(final WebElement element) {
        waitHelper.waitUntilVisibility(element);
        element.click();

    }
}
