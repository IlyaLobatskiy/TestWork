import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.apache.commons.validator.routines.EmailValidator;

@RunWith(Parameterized.class)
public class AuthorizationErrorsTest extends BaseTest {
    private final String email;
    private final String password;

    public AuthorizationErrorsTest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters(name = "E-Mail{0}, Password{1}")
    public static Object[][] paramData() {
        return new Object[][]{
                {"", ""},
                {"Test.ru", "test"},
                {"Test@test", "test"},
                {"Test@test.ru", ""},
        };
    }

    @Test
    @Description("Проверка ошибок при невалидных данных")
    public void authorizationParamTest() {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);

        authorizationPage.authorization(email, password);

        // Класс для проверки валидности Email
        EmailValidator validator = EmailValidator.getInstance();

        if (!validator.isValid(email)){
            Assert.assertEquals("Неверный текст ошибки", "Неверный формат E-Mail", authorizationPage.getTextError());
        } else {
            Assert.assertEquals("Неверный текст ошибки", "Неверный E-Mail или пароль", authorizationPage.getTextError());
        }


    }
}
