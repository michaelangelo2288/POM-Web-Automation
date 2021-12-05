import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.*;


public class LandingPageTest extends Base {

    Logger logger = LoggerFactory.getLogger(getClass());
    LandingPage landingPage;

//    @Before
//    public void setUp() {
//        init();
//    }
//
//    @Test
//    public void searchTest() {
//        SearchResultsPage searchResultsPage = landingPage.search("mike tran oakland");
//        logger.info(String.format("Search results: %d\n", landingPage.findElements(searchResultsPage.getSearchResultsLinks()).size()));
//        assertNotEquals("No results were found!", 0, landingPage.findElements(searchResultsPage.getSearchResultsLinks()));
//    }

    @Before
    public void setUp() {
        // *** Do not need to use init(), if LandingPage constructor instantiates WebDriver)
        init();
        landingPage = new LandingPage(driver);
    }

    @Test
    public void searchTest() {
        SearchResultsPage searchResultsPage = landingPage.search("mike tran oakland");
        logger.info(String.format("Search results: %d\n", landingPage.findElements(searchResultsPage.getSearchResultsLinks()).size()));
        assertNotEquals("No results were found!", 0, landingPage.findElements(searchResultsPage.getSearchResultsLinks()).size());
    }

    @Test
    public void bannerLogoHoverTest() {
        By privacyHeader = landingPage.getPrivacyHeader();

        landingPage.bannerLogoHover();
        landingPage.findElement(landingPage.getBannerLogo()).click();
        assertTrue("Privacy header is not displayed", landingPage.findElement(privacyHeader).isDisplayed());
        logger.info("bannerLogoHoverTest() completed");
    }

    @After
    public void tearDown() {
        landingPage.driver.quit();
    }
}
