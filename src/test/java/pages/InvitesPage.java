package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import constants.Urls;
import models.NewMemberModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class InvitesPage {

    private static final Logger LOGGER = LogManager.getLogger(InvitesPage.class.getName());

    private SelenideElement inviteMemberButton = $(By.xpath("//a[contains(text(), 'Invite new member')]"));
    private SelenideElement emailInput = $(By.id("email"));
    private SelenideElement nameInput = $(By.id("name"));
    private SelenideElement roleInput = $(By.id("role_title"));
    private SelenideElement roleDropDown = $(By.xpath("//div[@id='roleGroup']//div"));
    private SelenideElement memberOption = $(By.id("react-select-2-option-1"));
    private SelenideElement readOnlyCheckbox = $(By.xpath("//input[@name='read_only']/following-sibling::span"));
    private SelenideElement inviteButton = $(By.xpath("//button[contains(text(), 'Invite')]"));
    private SelenideElement successNotification = $(By.xpath("//span[contains(text(), 'User has been successfully invited')]"));

    public InvitesPage openInvitesPage() {
        open(Urls.INVITES_PAGE_URL);
        LOGGER.info(String.format("Page %s opened", InvitesPage.class.getName()));
        return this;
    }

    public InvitesPage fillInNewMemberForm(NewMemberModel memberModel) {
        String email = memberModel.getEmail();
        String name = memberModel.getName();
        String role = memberModel.getRole();

        inviteMemberButton.click();
        emailInput.shouldBe(Condition.visible, Duration.ofSeconds(5));
        emailInput.sendKeys(email);
        LOGGER.info(String.format("Email entered - %s", email));
        nameInput.sendKeys(name);
        LOGGER.info(String.format("Name entered - %s", name));
        roleInput.sendKeys(role);
        LOGGER.info(String.format("Role entered - %s", role));
        roleDropDown.click();
        memberOption.shouldBe(Condition.visible, Duration.ofSeconds(5));
        memberOption.click();
        readOnlyCheckbox.click();
        inviteButton.click();
        LOGGER.info(String.format("Invite button clicked"));
        return this;
    }

    public boolean isNotificationDisplayed() {
        successNotification.shouldBe(Condition.visible, Duration.ofSeconds(5));
        return successNotification.isDisplayed();
    }
}
