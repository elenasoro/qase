package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import constants.Urls;
import models.LoginModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPageWOCredentials {
    private SelenideElement emailField = $(By.id("inputEmail"));
    private SelenideElement passwordField = $(By.id("inputPassword"));
    private SelenideElement loginButton = $(By.id("btnLogin"));

    private static final Logger LOGGER = LogManager.getLogger(LoginPageWOCredentials.class.getName());

    public ProjectsPage login(LoginModel loginModel) {
        open(Urls.LOGIN_URL);
        LOGGER.info(String.format("Page %s opened", LoginPageWOCredentials.class.getName()));
        System.out.println(loginModel.getEmail());
        emailField.sendKeys(loginModel.getEmail());
        LOGGER.info(String.format("Email is entered"));
        passwordField.sendKeys(loginModel.getPassword());
        LOGGER.info(String.format("Password is entered"));
        loginButton.shouldBe(Condition.enabled, Duration.ofSeconds(5));
        loginButton.click();
        LOGGER.info(String.format("Login button clicked"));
        return new ProjectsPage();
    }


}
