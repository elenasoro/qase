package tests;

import constants.Credentials;
import models.NewProjectModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewProjectPage;
import pages.ProjectsPage;
import testdata.PrepareNewProjectData;

public class CreateProjectTest extends BaseTest{

    @Test
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
