package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class ActionHelper {
    private final WebDriver webDriver;
    private final WaitHelper waitHelper;
    private static Select select;

    // Constructor to accept a WaitHelper instance
    public ActionHelper(final WebDriver webDriver) {
        this.webDriver = webDriver;
        waitHelper = new WaitHelper(webDriver);
    }

    public boolean isDisplayed(WebElement element) {
        waitHelper.waitForPageLoadComplete(webDriver);
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void click(final WebElement element) {
        waitHelper.waitForPageLoadComplete(webDriver);
        try {
            waitHelper.waitUntilVisibility(element);
            waitHelper.waitUntilClickable(element);

            ((JavascriptExecutor) webDriver)
                    .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

            highlightElement(element);

            element.click();

        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            highlightElement(element);
            ((JavascriptExecutor) webDriver)
                    .executeScript("arguments[0].click();", element);
        } catch (Exception ex) {
            throw new RuntimeException("Click failed on element: " + element, ex);
        }
    }

    public void highlightElement(final WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript(
                "arguments[0].style.border='2px solid red';" +
                        "setTimeout(function(){arguments[0].style.border='';}, 10);",
                element
        );
    }

    public void clear(final WebElement element) {
        waitHelper.waitUntilVisibility(element);
        element.clear();
    }


    public void sendKeys(final WebElement element, final CharSequence... keys) {
        waitHelper.waitUntilVisibility(element);
        element.clear();
        element.sendKeys(keys);
    }

}
