import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }
    public List<WebElement> findAllElements(By locator){
        return driver.findElements(locator);
    }
    public void click(By locator){
        find(locator).click();
    }
    public void type(By locator, String text) throws InterruptedException {
        find(locator).clear();
        Thread.sleep(3000);
        find(locator).sendKeys(text);
        Thread.sleep(2000);
        find(locator).sendKeys(Keys.RETURN);

    }
    public void typeForLogin(By locator, String text) throws InterruptedException {
        find(locator).clear();
        Thread.sleep(3000);
        find(locator).sendKeys(text);
    }
    public boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }
}
