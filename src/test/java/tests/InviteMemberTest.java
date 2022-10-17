package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.LoginModel;
import models.NewMemberModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InvitesPage;
import pages.LoginPage;
import testdata.PrepareLoginData;
import testdata.PrepareNewMemberData;
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
        NewMemberModel memberModel = PrepareNewMemberData.getValidData();
        boolean isSuccessNotificationDisplayed = invitesPage
                .openInvitesPage()
                .fillInNewMemberForm(memberModel)
                .isNotificationDisplayed();
        Assert.assertTrue(isSuccessNotificationDisplayed, "Member is not invited");
    }
}
