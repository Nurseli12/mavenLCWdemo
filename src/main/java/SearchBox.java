import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage{
    public SearchBox(WebDriver driver) {
        super(driver);
    }
    By searchBoxLocator = By.id("search_input");

    public void search(String text) throws InterruptedException {
        Thread.sleep(6000);
        type(searchBoxLocator,text);
    }
}