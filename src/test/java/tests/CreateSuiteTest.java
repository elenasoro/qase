package tests;

import constants.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.NewSuiteModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectRepositoryPage;
import pages.ProjectsPage;
import testdata.PrepareNewSuiteData;
import utils.RetryAnalyzer;

public class CreateSuiteTest extends BaseTest{
    @Test(
            groups = {"smoke"},
            priority = 1,
            description = "Check that new suite is created successfully",
            retryAnalyzer = RetryAnalyzer.class,
            threadPoolSize = 2
    )
    @Description("Check that new suite is created successfully")
    @Severity(SeverityLevel.BLOCKER)
    public void createSuiteTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(Credentials.EMAIL, Credentials.PASSWORD_FOR_LOGIN);
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.openFirstProjectRepo();
        ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage();
        NewSuiteModel suiteModel = PrepareNewSuiteData.getValidData();
        boolean isSuccessNotificationDisplayed = projectRepositoryPage
                .openCreateSuiteForm()
                .fillInCreateSuiteForm(suiteModel)
                .isSuiteNotificationDisplayed();
        Assert.assertTrue(isSuccessNotificationDisplayed, "Suite is not created");
    }
}
