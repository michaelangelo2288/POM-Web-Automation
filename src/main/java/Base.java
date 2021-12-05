
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Getter
public class Base {
    public static WebDriver driver;
    String driverPath = "/Users/mike/IdeaProjects/WebAutomation/src/main/resources/assets/chromedriver";
    private Helpers helpers = new Helpers();

// *** Do not need to use init() for Test setUp(), if the following 2 lines are included in the
// *** page (LandingPage, ProductPage, etc) constructor) + pages are instantiated in setUp()
    public void init() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebElement findElement(By selector) {
        return driver.findElement(selector);
    }

    public List<WebElement> findElements(By selector) {
        return driver.findElements(selector);
    }

    public final class Helpers {
        public void mouseOver(WebElement we) {
            Actions actions = new Actions(driver);
            actions.moveToElement(we).perform();;
        }

        public WebElement waitFor(final int time, By selector) throws InterruptedException {
            Thread.sleep(2000);
            WebElement we = new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(selector));
            return we;
        }
    }

    // *** Explicit method, or can use @Getter (above) to use Helpers class + method
//    public Helpers getHelpers() {
//        return this.helpers;
//    }



    // explicitWait
}
