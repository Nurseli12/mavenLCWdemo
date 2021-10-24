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
        typeForLogin(typeEmailLocation,"nurselii07@gmail.com");
        Thread.sleep(500);
        typeForLogin(typePasswordLocation,"12345Nurseli12.");
        Thread.sleep(500);
        find(loginButtonLocation).click();
        Thread.sleep(500);
    }
}
