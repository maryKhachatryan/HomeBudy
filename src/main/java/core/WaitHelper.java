package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;


public class WaitHelper {
    private final WebDriver driver;
    private final Wait<WebDriver> wait;


    // Constructor that accepts driver and sets up default WebDriverWait
    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(14))
                .pollingEvery(Duration.ofSeconds(7))
                .ignoring(NoSuchElementException.class);
    }

    public void waitUntilVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void waitForPageLoadComplete(WebDriver driver) {
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete");
            }
        });
    }


}
