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

public class CreateCaseTest extends BaseTest{
    @Test(
            groups = {"smoke"},
            priority = 2,
            description = "Check that new test case is created successfully",
            retryAnalyzer = RetryAnalyzer.class
    )
    @Description("Check that new test case is created successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void createCaseTest() {
        LoginPage loginPage = new LoginPage();
        LoginModel loginModel = PrepareLoginData.getValidData();
        loginPage.login(loginModel);
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.openFirstProjectRepo();
        ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage();
        boolean isSuccessNotificationDisplayed = projectRepositoryPage
                .openCreateCasePage()
                .fillInCreateCaseForm()
                .isCaseNotificationDisplayed();
        Assert.assertTrue(isSuccessNotificationDisplayed, "Case is not created");
    }
}
