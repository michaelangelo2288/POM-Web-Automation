import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyBagPage {

    WebDriver driver;
    By guestCheckoutBtn = By.xpath("//*[@class='cart-summary__checkout']//following::a[2]");

    public MyBagPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutPage navToCheckout() {
        driver.findElement(guestCheckoutBtn).click();
        return new CheckoutPage();
    }
}
