import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage {
    WebDriver driver;
    private final WebElement dataEmail = driver.findElement(By.xpath("//input[@id='dataEmail']"));
    private final  WebElement dataName = driver.findElement(By.xpath("//input[@id='dataName']"));
    private final  WebElement dataGender = driver.findElement(By.xpath("//select[@id='dataGender']"));
    private final List<WebElement> gender = dataGender.findElements(By.xpath(".//select[@id='dataGender']/option"));
    private final WebElement dataSendButton = driver.findElement(By.xpath("//button[@id='dataSend']"));
    private final List<WebElement> checkBox = driver.findElements(By.xpath("//input[contains(@id, 'dataCheck')]"));
    private final List<WebElement> radioButton = driver.findElements(By.xpath("//input[contains(@id, 'dataSelect')]"));
    private final WebElement modalDialogButton = driver.findElement(By.xpath("//div[@class='uk-modal-dialog']//button"));
    private final List<WebElement> cotentTable = driver.findElements(By.xpath("//tr/td"));

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmail(String email){
        dataEmail.sendKeys(email);
    }

    public void inputName(String name){
        dataName.sendKeys(name);
    }

    // Для выбора пола передать 0 - мужчина, 1 - женщина.
    public void genderSelection(int i){
        dataGender.click();
        if (i == 1){
            gender.get(1).click();
        } else if (i == 0) {
            gender.get(0).click();
        }
    }

    // Для выбора чекбокса  передать 0 - Вариант 1.1, 1 - Вариант 1.2, 2 - Оба вариант
    public void checkBoxClick(int i){
        if(i == 0){
            checkBox.get(0).click();
        } else if (i == 1) {
            checkBox.get(1).click();
        } else if (i == 2) {
            checkBox.get(0).click();
            checkBox.get(1).click();
        }
    }

    //Для выбора радиокнопки передать 0 - Вариант 2.1, 1 - Вариант 2.2, 2 - Вариант 2.3
    public void radioButtonClick(int i){
        if (i == 0){
            radioButton.get(0).click();
        } else if (i == 1) {
            radioButton.get(1).click();
        } else if (i == 2) {
            radioButton.get(2).click();
        }
    }

    public void dataSendButtonClick(){
        dataSendButton.click();
    }

    public void addNewUser(String email, String name, int gen, int che, int rad){

        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        inputEmail(email);
        inputName(name);
        genderSelection(gen);
        checkBoxClick(che);
        radioButtonClick(rad);
        dataSendButtonClick();
    }

    public String getTextButton(){
        return dataSendButton.getText();
    }
}
