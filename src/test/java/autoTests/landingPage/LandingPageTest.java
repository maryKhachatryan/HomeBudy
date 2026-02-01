package autoTests.landingPage;

import autoTests.BaseTest;
import business.pages.LandingPage;
import core.ActionHelper;
import core.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listener.Listeners.class)
public class LandingPageTest extends BaseTest {
    private ActionHelper actionHelper;
    private LandingPage landingPage;
    private WaitHelper waitHelper;
    private WebDriver webDriver;

    @BeforeMethod
    public void init() {
        webDriver = getDriver();
        actionHelper = new ActionHelper(webDriver);
        landingPage = new LandingPage(webDriver);
        waitHelper = new WaitHelper(webDriver);
    }

    //Case1.TC-01: Verify that entering a valid ZIP Code allows proceeding to the next page
    @Test
    public void checkRedirectionAfterValidZipCode() {
        landingPage
                .enterZipCode("10001")
                .clickOnGetEstimateButton();

        Assert.assertTrue(landingPage.getTitleForTheFirstQuestion(), "The question is not found");
        Assert.assertTrue(landingPage.isCloseButtonDisplayed(), "Close (X) button is not displayed");

    }
}
