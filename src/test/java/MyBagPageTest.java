import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyBagPageTest extends Base{

    MyBagPage myBagPage;

    @Before
    public void setUp() {
        init();
        myBagPage = new ProductPage(driver).navToMyBag();
    }

    @Test
    public void navToCheckoutTest() {
        myBagPage.navToCheckout();
    }

    @After
    public void tearDown() {
        myBagPage.driver.quit();
    }
}
