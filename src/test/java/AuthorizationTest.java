import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class AuthorizationTest extends BaseTest{

    @Test
    @DisplayName("Авторизвция")
    @Description("Проверка авторизации")
    public void authorizationTest(){
        AuthorizationPage authorization = new AuthorizationPage(driver);

        String res = authorization.authorization(email, password).getTextButton();

        Assert.assertEquals("Пользователь не авторизован",
                "Добавить", res);
    }
}
