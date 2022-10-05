package tests;

import constants.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.LoginModel;
import models.NewProjectModel;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LoginPageWOCredentials;
import testdata.PrepareLoginData;
import testdata.PrepareNewProjectData;
import utils.RetryAnalyzer;

public class LoginTestWOCredentials extends BaseTest{

    @Test()
    public void loginTest() {
        LoginPageWOCredentials loginPage = new LoginPageWOCredentials();
        LoginModel loginModel = PrepareLoginData.getValidData();
        boolean isProjectsPageDisplayed = loginPage.login(loginModel)
                .isCreateButtonDisplayed();
        Assert.assertTrue(isProjectsPageDisplayed, "User is not logged in");
    }
}
