package autoTests.landingPage;

import autoTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LandingPageTest extends BaseTest {

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
