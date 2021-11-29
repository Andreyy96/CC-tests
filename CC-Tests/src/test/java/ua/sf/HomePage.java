package ua.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage {

    private static final String URL = "https://remanga.org/";
    private static final String BUTTON_INSIDE_XPATH = "//button[contains(@class, 'MuiButtonBase-root c30')]";
    private static final String BUTTON_REGISTRATION_XPATH = "//span[contains(@to, 'signup')]";
    private static final String FIELD_USERNAME_NAME = "username";
    private static final String FIELD_PASSWORD_NAME = "password";
    private static final String FIELD_CONFIRM_PASSWORD_NAME = "confirm_password";
    private static final String BUTTON_REGISTRATION_IN_THE_REGISTRATION_FORM_XPATH = "//span[contains(text(),'Регистрация')]";
    private static final String ERROR_PASSWORD_MESSAGE_XPATH = "//label[contains(text(), 'Слишком короткий пароль')]";

    private final WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver =webDriver;
    }

    public void go() {
        webDriver.get(URL);
    }

    public void clickInside() {
        webDriver.findElement(By.xpath(BUTTON_INSIDE_XPATH)).click();
    }

    public void clickRegistration() {
        webDriver.findElement(By.xpath(BUTTON_REGISTRATION_XPATH)).click();
    }

    public void writeUsername(String text) {
        final var writeInput = webDriver.findElement(By.name(FIELD_USERNAME_NAME));
        writeInput.sendKeys(text);
    }

    public void writePassword(String password) {
        final var writePassword = webDriver.findElement(By.name(FIELD_PASSWORD_NAME));
        writePassword.sendKeys(password);
    }

    public void writeConfirmPassword(String confirmPassword) {
        final var writeConfirmPassword = webDriver.findElement(By.name(FIELD_CONFIRM_PASSWORD_NAME));
        writeConfirmPassword.sendKeys(confirmPassword);
    }

    public void createAccount() {
        webDriver.findElement(By.xpath(BUTTON_REGISTRATION_IN_THE_REGISTRATION_FORM_XPATH)).click();
    }

    public String getErrorPasswordMessage() {
        return webDriver.findElement(By.xpath(ERROR_PASSWORD_MESSAGE_XPATH)).getText();


    }
}
