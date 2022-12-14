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

public class PassCaseTest extends BaseTest{
    @Test(groups = {"smoke"}, priority = 3, description = "Mark test case in run as Passed", retryAnalyzer = RetryAnalyzer.class)
    @Description("Mark test case in run as Passed")
    @Severity(SeverityLevel.NORMAL)
    public void passCaseTest() {
        LoginPage loginPage = new LoginPage();
        LoginModel loginModel = PrepareLoginData.getValidData();
        loginPage.login(loginModel);
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.openFirstProjectRepo();
        ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage();
        boolean isPassedLabelDisplayed = projectRepositoryPage
                .openTestRunsPage()
                .passCase()
                .isPassedLabelDisplayed();
        Assert.assertTrue(isPassedLabelDisplayed, "Case is not passed");
    }
}
