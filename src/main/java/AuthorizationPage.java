import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AuthorizationPage {
    WebDriver driver;
    private final By fieldEmail = By.xpath("//input[@id='loginEmail']");
    private final By fieldPassword = By.xpath("//input[@id='loginPassword']");
    private final By authButton = By.xpath("//*[@id='authButton']");
    private final By emailFormatError = By.xpath("//div[@class='uk-alert uk-alert-danger']");

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmail(String email){
        driver.findElement(fieldEmail).sendKeys(email);
    }

    public void inputPassword(String password){
        driver.findElement(fieldPassword).sendKeys(password);
    }

    public void clicButton(){
        driver.findElement(authButton).click();
    }

    public MainPage authorization(String email, String password){
        inputEmail(email);
        inputPassword(password);
        clicButton();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new MainPage(driver);
    }

    public String getTextError(){
        return driver.findElement(emailFormatError).getText();
    }
}
