package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.LoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectRepositoryPage;
import pages.ProjectsPage;
import testdata.PrepareLoginData;
import utils.RetryAnalyzer;

public class StartRunTest extends BaseTest{
    @Test(groups = {"smoke"}, priority = 2, description = "Run can be started", retryAnalyzer = RetryAnalyzer.class)
    @Description("Run can be started")
    @Severity(SeverityLevel.CRITICAL)
    public void startRunTest() {
        LoginPage loginPage = new LoginPage();
        LoginModel loginModel = PrepareLoginData.getValidData();
        loginPage.login(loginModel);
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.openFirstProjectRepo();
        ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage();
        boolean isSuccessNotificationDisplayed = projectRepositoryPage
                .openTestRunsPage()
                .startNewRun()
                .isNotificationDisplayed();
        Assert.assertTrue(isSuccessNotificationDisplayed, "Run is not started");
    }
}
