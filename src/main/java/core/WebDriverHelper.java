package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverHelper {

    private static volatile WebDriverHelper instance;
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    private WebDriverHelper() {

    }

    private void initDriver(final String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                tlDriver.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                tlDriver.set(new EdgeDriver());
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    public static WebDriverHelper getInstance(final String browser) {
        if (instance == null) {
            synchronized (WebDriverHelper.class) {
                if (instance == null) {
                    instance = new WebDriverHelper();
                }
            }
        }

        if (tlDriver.get() == null) {
            instance.initDriver(browser);
        }
        return instance;
    }

    public WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitBrowser() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
