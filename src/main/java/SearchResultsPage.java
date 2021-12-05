import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class SearchResultsPage extends Base {
    By noSearchResultsText = By.className(".no-results__title");
    By searchResultsLinks = By.cssSelector("#links .result");
}
