import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    By typeEmailLocation = By.xpath("//input[@id='LoginEmail']");
    By typePasswordLocation = By.xpath("//input[@id='Password']");
    By loginButtonLocation = By.xpath("//a[@id='loginLink']");


    public void beLogin() throws InterruptedException {
        typeForLogin(typeEmailLocation,"nurseli.kaya_1997@outlook.com");
        Thread.sleep(500);
        typeForLogin(typePasswordLocation,"123456nurseli");
        Thread.sleep(500);
        find(loginButtonLocation).click();
        Thread.sleep(500);
    }
}
