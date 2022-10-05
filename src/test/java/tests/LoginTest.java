package tests;

import constants.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.RetryAnalyzer;

public class LoginTest extends BaseTest{

    @Test(
            groups = {"smoke"},
            priority = 1,
            description = "Successful login to the app",
            retryAnalyzer = RetryAnalyzer.class,
            threadPoolSize = 2,
            invocationCount = 2
    )
    @Description("Successful login to the app")
    @Severity(SeverityLevel.BLOCKER)
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        boolean isProjectsPageDisplayed = loginPage.
//                login(Credentials.EMAIL, Credentials.PASSWORD_FOR_LOGIN)
        login(System.getProperty("email", "sorokina.eln@gmail.com"), System.getProperty("password", "12345123"))
                .isCreateButtonDisplayed();
        Assert.assertTrue(isProjectsPageDisplayed, "User is not logged in");
    }
}
