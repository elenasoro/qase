package tests;

import constants.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectRepositoryPage;
import pages.ProjectsPage;
import utils.RetryAnalyzer;

public class FailCaseTest extends BaseTest{
    @Test(groups = {"smoke"}, priority = 3, description = "Mark test case in run as Failed", retryAnalyzer = RetryAnalyzer.class)
    @Description("Mark test case in run as Failed")
    @Severity(SeverityLevel.NORMAL)
    public void failCaseTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(Credentials.EMAIL, Credentials.PASSWORD_FOR_LOGIN);
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.openFirstProjectRepo();
        ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage();
        boolean isFailedLabelDisplayed = projectRepositoryPage
                .openTestRunsPage()
                .failCase()
                .isFailedLabelDisplayed();
        Assert.assertTrue(isFailedLabelDisplayed, "Case is not failed");
    }
}
