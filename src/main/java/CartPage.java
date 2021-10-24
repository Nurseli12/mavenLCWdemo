import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    int productAmount = 1;
    By priceOnCartLocator = By.xpath("//span[@class='rd-cart-item-price mb-15']");
    By increaseButtonLocator = By.xpath("//a[contains(@id,'Cart_AddQuantity')]");
    By removeCartLocator = By.xpath("//a[@title='Sil']");
    By confirmRemoveLocator = By.xpath("//a[@class='inverted-modal-button sc-delete ins-init-condition-tracking']");
    public void increaseProductAmount() throws InterruptedException {
        find(increaseButtonLocator).click();
        productAmount++;
    }
    public boolean checkProductAmount(){
        return productAmount ==2;
    }
    public boolean checkTwoPrices(String givenPrice){
        return givenPrice.equals(getPriceOnCart());
    }
    public void removeCart() throws InterruptedException {
        find(removeCartLocator).click();
        Thread.sleep(500);
        find(confirmRemoveLocator).click();
        productAmount = 0;
    }
    public boolean checkIsCartRemoved(){
        return productAmount == 0;
    }

    public String getPriceOnCart(){
        return find(priceOnCartLocator).getText();
    }
}