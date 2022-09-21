package tests;

import constants.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        boolean isProjectsPageDisplayed = loginPage.
                login(Credentials.EMAIL, Credentials.PASSWORD_FOR_LOGIN)
                .isCreateButtonDisplayed();
        Assert.assertTrue(isProjectsPageDisplayed, "User is not logged in");
    }
}
