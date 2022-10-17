package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import models.NewDefectModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class DefectsPage {

    private static final Logger LOGGER = LogManager.getLogger(DefectsPage.class.getName());

    private SelenideElement createDefectButton = $(By.xpath("//a[contains(text(), 'Create new defect')]"));
    private SelenideElement titleInput = $(By.id("title"));
    private SelenideElement actualResultInput = $(By.id("actual_result"));
    private SelenideElement createButton = $(By.xpath("//button[contains(text(), 'Create defect')]"));
    private SelenideElement successNotification = $(By.xpath("//span[contains(text(), 'Defect was created successfully!')]"));
    private SelenideElement firstDefectLink = $(By.xpath("//tr[1]//a[@class='defect-title']"));
    private SelenideElement currentStatus = $(By.xpath("//div[contains(text(), 'Status')]/following-sibling::div//span"));
    private SelenideElement inProgressButton = $(By.xpath("//button[contains(@class, 'defect-in-progress')]"));
    private SelenideElement resolvedButton = $(By.xpath("//button[contains(@class, 'defect-resolve')]"));
    private SelenideElement inProgressText = $(By.xpath("//p[contains(text(), 'This defect will be marked as in progress.')]"));
    private SelenideElement resolvedText = $(By.xpath("//p[contains(text(), 'This defect will be marked as resolved.')]"));
    private SelenideElement confirmButton = $(By.xpath("//button[contains(text(), 'Confirm')]"));


    public DefectsPage fillInCreateDefectsForm(NewDefectModel defectModel) {
        String defectTitle = defectModel.getTitle();
        String actualResult = defectModel.getActualResult();
        createDefectButton.click();
        LOGGER.info(String.format("Create defect button clicked"));
        titleInput.shouldBe(Condition.visible, Duration.ofSeconds(5));
        titleInput.sendKeys(defectTitle);
        LOGGER.info(String.format("Defect title entered - %s", defectTitle));
        actualResultInput.sendKeys(actualResult);
        LOGGER.info(String.format("Actual result entered - %s", actualResult));
        createButton.click();
        LOGGER.info(String.format("Create button clicked"));
        return this;
    }

    public boolean isSuccessNotificationDisplayed() {
        successNotification.shouldBe(Condition.visible, Duration.ofSeconds(5));
        return successNotification.isDisplayed();
    }

    public DefectsPage openDefectPage() {
        firstDefectLink.shouldBe(Condition.visible, Duration.ofSeconds(5));
        firstDefectLink.click();
        return this;
    }

    public String getCurrentStatus() {
        Selenide.refresh();
        return currentStatus.getText();
    }

    public DefectsPage changeStatusToInProgress() {
        inProgressButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        inProgressButton.click();
        inProgressText.shouldBe(Condition.visible, Duration.ofSeconds(5));
        confirmButton.click();
        return this;
    }

    public DefectsPage changeStatusToResolved() {
        resolvedButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        resolvedButton.click();
        resolvedText.shouldBe(Condition.visible, Duration.ofSeconds(5));
        confirmButton.click();
        return this;
    }
}
