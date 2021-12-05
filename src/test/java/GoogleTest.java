import com.google.common.annotations.VisibleForTesting;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
    String driverPath = "/Users/mike/IdeaProjects/WebAutomation/src/main/resources/assets/chromedriver-old";
    private WebDriver chromeDriver;

    By searchField = By.cssSelector("[title='Search']");
    // xpath selector
    // sibling
    // preceding
    // following

    // Action
    // mouseover/hover
    // implicit/explicit wait - make it a helper
    // isDisplay, isPresent - immediately or after timeout




    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void googleSearchTest() {

        String searchTerm = "mike tran oakland";
        chromeDriver.get("https://www.google.com");
        chromeDriver.findElement(searchField).sendKeys(searchTerm);
        chromeDriver.findElement(searchField).sendKeys(Keys.ENTER);




//        searchField.sendKeys(searchTerm);


    }

    @After
    public void tearDown() {
        chromeDriver.quit();
    }
}
