package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import constants.Urls;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private SelenideElement emailField = $(By.id("inputEmail"));
    private SelenideElement passwordField = $(By.id("inputPassword"));
    private SelenideElement loginButton = $(By.id("btnLogin"));

    public ProjectsPage login(String email, String password) {
        open(Urls.LOGIN_URL);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.shouldBe(Condition.enabled, Duration.ofSeconds(5));
        loginButton.click();
        return new ProjectsPage();
    }


}
