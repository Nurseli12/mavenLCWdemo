import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailPage extends BasePage{
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    By sizeLocator = By.xpath("//a[@key='2']");
    By addToCartButtonLocator = By.id("pd_add_to_cart");
    By priceLocation = By.xpath("//span[@class='price']");
    String price = null;
    public void selectSize(){
        webElementList().get(0).click();
    }

    public void addToCart() throws InterruptedException {
        click(addToCartButtonLocator);
        Thread.sleep(2000);
        price = getListElements().get(1).getText();
        Thread.sleep(500);
        driver.get("https://www.lcwaikiki.com/tr-TR/TR/sepetim");
    }

    public String rememberPrice(){
        return price;
    }
    private List<WebElement> webElementList(){
        return findAllElements(sizeLocator);
    }
    private List<WebElement> getListElements(){
        return findAllElements(priceLocation);
    }
}
