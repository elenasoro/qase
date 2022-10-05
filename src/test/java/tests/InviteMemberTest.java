package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.LoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InvitesPage;
import pages.LoginPage;
import testdata.PrepareLoginData;
import utils.RetryAnalyzer;

public class InviteMemberTest extends BaseTest{
    @Test(groups = {"smoke"}, priority = 2, description = "Invite new member with Read Only role", retryAnalyzer = RetryAnalyzer.class)
    @Description("Invite new member with Read Only role")
    @Severity(SeverityLevel.CRITICAL)
    public void inviteMemberTest() {
        LoginPage loginPage = new LoginPage();
        LoginModel loginModel = PrepareLoginData.getValidData();
        loginPage.login(loginModel);
        InvitesPage invitesPage = new InvitesPage();
        boolean isSuccessNotificationDisplayed = invitesPage
                .openInvitesPage()
                .fillInNewMemberForm()
                .isNotificationDisplayed();
        Assert.assertTrue(isSuccessNotificationDisplayed, "Member is not invited");
    }
}
