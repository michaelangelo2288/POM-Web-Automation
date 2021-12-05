import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductPageTest extends Base {

    ProductPage productPage;

    @Before
    public void setUp() {
        init();
        productPage = new ProductPage(driver);
    }

    @Test
    public void addToBagTest() {
        productPage.addToBag();
        // assertion my bag counter incremented
    }

    @Test
    public void navToMyBagTest() {
        productPage.addToBag();
        MyBagPage myBagPage = productPage.navToMyBag();
        assertTrue("Guest checkout button is not displayed", myBagPage.driver.findElement(myBagPage.guestCheckoutBtn).isDisplayed());
    }

    @After
    public void tearDown() {
        productPage.driver.quit();
    }
}
