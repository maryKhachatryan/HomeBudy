package autoTests;

import business.BasePage;
import business.pages.LandingPage;
import core.WaitHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import static business.data.CommonData.BASE_URL;

public class BaseTest {

    private static ChromeDriver chromeDriver;

    private static JavascriptExecutor executor;

    protected BasePage basePage;

    protected LandingPage landingPage;



    protected WaitHelper waitHelper;

    public BaseTest() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        basePage = new BasePage(chromeDriver);
        landingPage = new LandingPage(chromeDriver);
        waitHelper = new WaitHelper(chromeDriver);

        executor = (JavascriptExecutor) chromeDriver;
    }

    public static ChromeDriver getChromeDriver() {
        return chromeDriver;
    }

    public static void scrollTo() {
        executor.executeScript("window.scrollBy(0,350)", "");
    }

    public void switchToNewWindow() {
        String originalWindowHandle = chromeDriver.getWindowHandle();

        for (String windowHandle : chromeDriver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindowHandle)) {
                chromeDriver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void switchToOriginalWindow() {
        for (String windowHandle : chromeDriver.getWindowHandles()) {
            chromeDriver.switchTo().window(windowHandle);
            break;
        }
    }


    @BeforeMethod
    public void open() {
        // Set up the ChromeOptions
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("no-first-run");
//        options.addArguments("disable-default-apps");
//        options.addArguments("no-default-browser-check");
//        options.addArguments("--disable-search-engine-choice-screen");
//        options.addArguments("--user-data-dir=/path/to/your/custom/profile");

        // Initialize WebDriver with ChromeOptions
        //chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();

//        try {
//            chromeDriver.switchTo().alert().dismiss();
//        } catch (NoAlertPresentException e) {
//            // No alert found, continue with the test
//        }
//        String originalWindow = chromeDriver.getWindowHandle();
//        for (String windowHandle : chromeDriver.getWindowHandles()) {
//            if (!windowHandle.equals(originalWindow)) {
//                chromeDriver.switchTo().window(windowHandle);
//                chromeDriver.close();
//                chromeDriver.switchTo().window(originalWindow);
//            }
        //  }
        chromeDriver.get(BASE_URL);

    }

    @AfterMethod
    public void cleaningCookies(){
        getChromeDriver().manage().deleteAllCookies();
        getChromeDriver().getLocalStorage().clear();
    }

    @AfterSuite
    public void close(){
        chromeDriver.close();
    }
}
