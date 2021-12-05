import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Getter
public class LandingPage extends Base {

    WebDriver driver;

    LandingPage(WebDriver driver) {
//        System.setProperty("webdriver.chrome.driver", driverPath);
//        driver = new ChromeDriver();
        this.driver = driver;
    }

    By searchField = By.cssSelector("#search_form_homepage > input:nth-child(1)");
    By bannerLogo = By.id("logo_homepage_link");
    By privacyHeader = By.xpath("//*[@class='onboarding-ed__content']/h1[contains(text(), 'We don’t store your')]");

    public SearchResultsPage search(String keywords) {
        driver.get("https://www.duckduckgo.com");
        driver.findElement(searchField).sendKeys(keywords);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        return new SearchResultsPage();
    }

    public void bannerLogoHover() {
        driver.get("https://www.duckduckgo.com");
        getHelpers().mouseOver(driver.findElement(bannerLogo));
    }
}
