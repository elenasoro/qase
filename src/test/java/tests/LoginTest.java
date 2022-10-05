package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.LoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import testdata.PrepareLoginData;
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
        LoginModel loginModel = PrepareLoginData.getValidData();
        boolean isProjectsPageDisplayed = loginPage
                .login(loginModel)
                .isCreateButtonDisplayed();
        Assert.assertTrue(isProjectsPageDisplayed, "User is not logged in");
    }
}
