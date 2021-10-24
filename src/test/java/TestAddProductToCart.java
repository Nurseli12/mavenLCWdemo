import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAddProductToCart extends BaseTest{

    HomePage homePage;
    LoginPage loginPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    String tempPrice = null;

    @Test
    @Order(1)
    public void loginControl() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.goToLoginPage();
        Thread.sleep(1000);
        loginPage = new LoginPage(driver);
        loginPage.beLogin();
        Thread.sleep(3000);
    }

    @Test
    @Order(2)
    public void baseControl() throws InterruptedException {
        homePage = new HomePage(driver);
        productDetailPage  = new ProductDetailPage(driver);
        homePage.searchBox.search("pantolan");
        Thread.sleep(2000);
        homePage.goToEndOfPage();
        Thread.sleep(2000);
        homePage.clickTheMoreProductButton();
        Thread.sleep(2000);
        homePage.clickAnyProduct(0);
        Thread.sleep(2000);
        productDetailPage.selectSize();
        Thread.sleep(2000);
        productDetailPage.addToCart();
        tempPrice = productDetailPage.rememberPrice();
        Thread.sleep(5000);

    }
    @Test
    @Order(2)
    public void samePriceControl(){
        cartPage = new CartPage(driver);
        assertEquals(true,cartPage.checkTwoPrices(tempPrice));
    }
    @Test
    @Order(3)
    public void unitAmountControl() throws InterruptedException {
        cartPage = new CartPage(driver);
        cartPage.increaseProductAmount();
        Thread.sleep(2000);
        assertEquals(true,cartPage.checkProductAmount());
    }
    @Test
    @Order(4)
    public void removeCartControl() throws InterruptedException {
        cartPage = new CartPage(driver);
        cartPage.removeCart();
        Thread.sleep(1000);
        cartPage.checkIsCartRemoved();
        Thread.sleep(2000);
        assertEquals(true, cartPage.checkIsCartRemoved());
    }
}

