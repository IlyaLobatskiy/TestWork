import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    protected final String email = "test@protei.ru";
    protected final String password = "test";

    @Before
    public void instalDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:////D:/Learn/TestWork/src/test/resources/qa-test.html");
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

}
