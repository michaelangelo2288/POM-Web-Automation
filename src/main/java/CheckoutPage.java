import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends Base {

    By shippingCountryDropDown = By.id("shippingCountrydefault");
    By selectedCountry = null;

    public void selectCountry(String country) {
        this.selectedCountry = By.xpath("//*[@id='shippingCountrydefault']//option[@id='"+ country +"']");
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(selectedCountry));
        driver.findElement(shippingCountryDropDown).click();
        driver.findElement(selectedCountry).click();
    }
}
