import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import java.util.List;
public class HomePage extends BasePage{
    SearchBox searchBox;

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }
    By moreProductButtonLocator = By.xpath("//a[@class='lazy-load-button']");
    By productSelectLocator = By.xpath("//img[@class='product-lazy-image lazyloaded']");
    By loginPageLocator = By.xpath("//a[@href='https://www.lcwaikiki.com/tr-TR/TR/giris']");
    public void goToEndOfPage(){
        JavascriptExecutor js =  (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,111350)");
    }
    public void clickTheMoreProductButton(){
        click(moreProductButtonLocator);
    }

    public void clickAnyProduct(int index){
        webElementList().get(index).click();
    }

    public SearchBox searchBox(){
        return this.searchBox;
    }
    public void goToLoginPage(){
        find(loginPageLocator).click();
    }
    private List<WebElement> webElementList(){
        return findAllElements(productSelectLocator);
    }

}