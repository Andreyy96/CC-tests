package ua.sf;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {
    public static final WebDriver webDriver;
    public static final HomePage homePage;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Андрей\\IdeaProjects\\CC-Tests\\src\\test\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        webDriver.manage().window().maximize();
        homePage = new HomePage(webDriver);
    }

    @Given("url of remanga {string}")
    public void url_of_remanga(String url) {
        homePage.go();
    }

    @When("website is open click button inside")
    public void website_is_open_click_button_inside() {
        homePage.clickInside();
    }

    @Then("click button registration")
    public void click_button_registration() {
        homePage.clickRegistration();
    }

    @Then("enter in the field username text {string}")
    public void enter_in_the_field_username_text(String text) {
        homePage.writeUsername(text);
    }

    @Then("enter in the field password {string}")
    public void enter_in_the_field_password(String password) {
        homePage.writePassword(password);
    }

    @Then("enter in the field confirmPassword {string}")
    public void enter_in_the_field_confirm_password(String confirmPassword) {
        homePage.writeConfirmPassword(confirmPassword);
    }

    @Then("click button create account")
    public void click_button_create_account() {
        homePage.createAccount();
    }

    @Then("assert that user got message {string}")
    public void assert_that_user_got_message(String errorMessage) {
        final var errorPasswordMessage = homePage.getErrorPasswordMessage();
        assertEquals(errorMessage, errorPasswordMessage);
    }
}