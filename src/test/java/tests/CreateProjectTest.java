package tests;

import constants.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.NewProjectModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewProjectPage;
import pages.ProjectsPage;
import testdata.PrepareNewProjectData;
import utils.RetryAnalyzer;

public class CreateProjectTest extends BaseTest{

    @Test(
            groups = {"smoke"},
            priority = 1,
            description = "Check that new project is created successfully",
            retryAnalyzer = RetryAnalyzer.class,
            threadPoolSize = 2
    )
    @Description("Check that new project is created successfully")
    @Severity(SeverityLevel.BLOCKER)
    public void createNewProjectTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(Credentials.EMAIL, Credentials.PASSWORD_FOR_LOGIN);
        NewProjectPage newProjectPage = new NewProjectPage();
        NewProjectModel projectModel = PrepareNewProjectData.getValidData();
        newProjectPage
                .openNewProjectPage()
                .fillInCreateForm(projectModel);
        ProjectsPage projectsPage = new ProjectsPage();
        boolean isProjectCreated = projectsPage.openProjectsPage().isCreatedProjectPresent(projectModel.getName());
        Assert.assertTrue(isProjectCreated, "Project is not created");
    }
}
