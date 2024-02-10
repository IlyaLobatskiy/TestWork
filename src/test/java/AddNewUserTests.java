import org.junit.Test;


public class AddNewUserTests extends BaseTest {
    @Test
    public void addNewUserTest(){
        MainPage mainPage = new AuthorizationPage(driver).authorization(email, password);

        mainPage.addNewUser(email, "name", 0, 1, 2);
    }
}
