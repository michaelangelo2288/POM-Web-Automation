import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ProductPage {
    WebDriver driver;
    String productPage = "https://www.shopdisney.com/412354174663.html";

    By addToBagButton = By.cssSelector(".add-to-cart.button--primary");
    By miniBagHeader = By.xpath("//*[@class='minibag__section minibag__header']");
    By viewFullBag = By.cssSelector(".minibag__section .checkout-btn");

    By myBagBtn1 = By.xpath("//a[contains(@title, 'View Cart')]");
    By myBagBtn2 = By.xpath("//a[@class='minicart-link']");
    By myBagBtn3 = By.xpath("//*[text()='My Bag']");
    By myBagBtn4 = By.xpath("//*[contains(text(), 'My Bag')]");      // this may return more results than myBagBtn3

    // *** Using AND
    By addToWishListBtn = By.xpath("//*[contains(@class,'add-to-wish-list') and @type='submit']");

    // *** Using axes method: following::
    By quantityDownBtn1 = By.xpath("//*[@class='product__qty_button-container']//following::button[1]");
    By quantityUpBtn1 = By.xpath("//*[@class='product__qty_button-container']//following::button[2]");

    // *** Using axes method: child::
    By quantityDownBtn2 = By.xpath("//*[@class='product__qty_button-container']//child::button[1]");
    By quantityUpBtn2 = By.xpath("//*[@class='product__qty_button-container']//child::button[2]");


    ProductPage(WebDriver wd) {
//        System.setProperty("webdriver.chrome.driver", driverPath);
//        driver = new ChromeDriver();
        this.driver = wd;
        Dimension dimension = new Dimension(1600,1000);
        this.driver.manage().window().setSize(dimension);
        this.driver.get(productPage);
    }

    public void addToBag() {
        driver.findElement(quantityUpBtn1).click();
        driver.findElement(addToBagButton).click();
    }

    public MyBagPage navToMyBag() {
        addToBag();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(miniBagHeader));
        driver.findElement(viewFullBag).click();
        return new MyBagPage(driver);
    }

}
