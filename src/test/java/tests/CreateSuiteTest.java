package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.LoginModel;
import models.NewSuiteModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectRepositoryPage;
import pages.ProjectsPage;
import testdata.PrepareLoginData;
import testdata.PrepareNewSuiteData;
import utils.RetryAnalyzer;

public class CreateSuiteTest extends BaseTest{
    @Test(
            groups = {"smoke"},
            priority = 1,
            description = "Check that new suite is created successfully",
            retryAnalyzer = RetryAnalyzer.class
    )
    @Description("Check that new suite is created successfully")
    @Severity(SeverityLevel.BLOCKER)
    public void createSuiteTest() {
        LoginPage loginPage = new LoginPage();
        LoginModel loginModel = PrepareLoginData.getValidData();
        loginPage.login(loginModel);
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
