package autoTests;

import core.WebDriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static business.data.CommonData.BASE_URL;

public class BaseTest {
    private static WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(@Optional("chrome") final String browser) {
        driver = WebDriverHelper.getInstance(browser).getDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(BASE_URL);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void teardown() {
        WebDriverHelper.quitBrowser();
    }
}
