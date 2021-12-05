import com.sun.tools.javac.comp.Check;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CheckoutPageTest extends Base {

    CheckoutPage checkoutPage;

    @Before
    public void setUp() {
        init();
        ProductPage productPage = new ProductPage(driver);
        MyBagPage myBagPage = productPage.navToMyBag();
        checkoutPage = myBagPage.navToCheckout();
    }

    @Test
    public void selectCountryTest() {
        checkoutPage.selectCountry("CA");
        // assertion
    }

    @After
    public void tearDown() {
        checkoutPage.driver.quit();
    }
}
