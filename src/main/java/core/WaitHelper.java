package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    private WebDriver driver;
    private WebDriverWait wait;
    private int defaultTimeout = 60;

    // Constructor that accepts driver and sets up default WebDriverWait
    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, defaultTimeout);
    }

    // Constructor to pass a custom timeout for the entire class
    public WaitHelper(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeoutInSeconds);
    }

    public void waitUntilVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilVisibility(WebElement element, int sec) {
        new WebDriverWait(driver, sec)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilClickable(WebElement element, int sec) {
        new WebDriverWait(driver, sec)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilUrlEndsWith(final String path) {
        wait.until((ExpectedCondition<Boolean>) wd ->
                wd.getCurrentUrl().endsWith(path));
    }

    public void waitUntilUrlContains(String partialUrl) {
        new WebDriverWait(driver, defaultTimeout)
                .until(ExpectedConditions.urlContains(partialUrl));
    }

}

