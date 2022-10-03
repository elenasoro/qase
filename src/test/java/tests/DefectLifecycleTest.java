package tests;

import constants.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DefectsPage;
import pages.LoginPage;
import pages.ProjectRepositoryPage;
import pages.ProjectsPage;
import utils.RetryAnalyzer;

public class DefectLifecycleTest extends BaseTest{

    @Test(groups = {"smoke"}, priority = 3, description = "Check defect lifecycle (Open -> In Progress -> Resolved)", retryAnalyzer = RetryAnalyzer.class)
    @Description("Check defect lifecycle (Open -> In Progress -> Resolved)")
    @Severity(SeverityLevel.NORMAL)
    public void checkDefectLifecycleTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(Credentials.EMAIL, Credentials.PASSWORD_FOR_LOGIN);
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.openFirstProjectRepo();
        ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage();
        projectRepositoryPage.openDefectsPage();
        DefectsPage defectsPage = new DefectsPage();
        String openStatus = defectsPage.openDefectPage().getCurrentStatus();
        String inProgressStatus = defectsPage.changeStatusToInProgress().getCurrentStatus();
        String resolvedStatus = defectsPage.changeStatusToResolved().getCurrentStatus();
        Assert.assertEquals(openStatus, "Open", "Incorrect status: Expected Open");
        Assert.assertEquals(inProgressStatus, "In Progress", "Incorrect status: Expected In Progress");
        Assert.assertEquals(resolvedStatus, "Resolved", "Incorrect status: Expected Resolved");
    }
}
