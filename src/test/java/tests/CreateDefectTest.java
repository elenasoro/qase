package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.LoginModel;
import models.NewDefectModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectRepositoryPage;
import pages.ProjectsPage;
import testdata.PrepareLoginData;
import testdata.PrepareNewDefectData;
import utils.RetryAnalyzer;

public class CreateDefectTest extends BaseTest{
    @Test(groups = {"smoke"}, priority = 2, description = "Check that new test case is created successfully", retryAnalyzer = RetryAnalyzer.class)
    @Description("Check that new test case is created successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void createDefectTest() {
        LoginPage loginPage = new LoginPage();
        LoginModel loginModel = PrepareLoginData.getValidData();
        loginPage.login(loginModel);
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.openFirstProjectRepo();
        ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage();
        NewDefectModel defectModel = PrepareNewDefectData.getValidData();
        boolean isSuccessNotificationDisplayed = projectRepositoryPage
                .openDefectsPage()
                .fillInCreateDefectsForm(defectModel)
                .isSuccessNotificationDisplayed();
        Assert.assertTrue(isSuccessNotificationDisplayed, "Defect is not created");
    }
}
