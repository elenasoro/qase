package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class TestRunsPage {
    private SelenideElement startRunButton = $(By.id("start-new-test-run-button"));
    private SelenideElement addCasesButton = $(By.id("edit-run-add-cases-button"));
    private SelenideElement firstSuiteCheckbox = $(By.xpath("//div[@class='checkbox'][1]//span"));
    private SelenideElement doneButton = $(By.id("select-cases-done-button"));
    private SelenideElement saveRunButton = $(By.id("save-run-button"));
    private SelenideElement successNotification = $(By.xpath("//span[contains(text(), 'Run was created successfully!')]"));
    private SelenideElement firstRunTitle = $(By.xpath("//tr[@class='project-row']//a[@class='defect-title'][1]"));
    private SelenideElement firstCaseLink = $(By.xpath("//div[@class='run-suite-cases']//a[1]"));
    private SelenideElement secondCaseLink = $(By.xpath("//div[@class='run-suite-cases']/div[2]/a"));
    private SelenideElement passButton = $(By.xpath("//button[contains(text(), 'Passed')]"));
    private SelenideElement failButton = $(By.xpath("//button[contains(text(), 'Failed')]"));
    private SelenideElement passedLabel = $(By.xpath("//div[@class='run-suite-cases']//span[contains(text(), 'Passed')]"));
    private SelenideElement failedLabel = $(By.xpath("//div[@class='run-suite-cases']//span[contains(text(), 'Failed')]"));
    private SelenideElement addResultButton = $(By.xpath("//button//span[contains(text(), 'Add result')]"));
    private SelenideElement cancelButton = $(By.xpath("//button//span[contains(text(), 'Cancel')]"));

    public TestRunsPage startNewRun() {
        startRunButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        startRunButton.click();
        addCasesButton.scrollIntoView(true).click();
        firstSuiteCheckbox.click();
        doneButton.click();
        saveRunButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        saveRunButton.click();
        return this;
    }

    public boolean isNotificationDisplayed() {
        successNotification.shouldBe(Condition.visible, Duration.ofSeconds(5));
        return successNotification.isDisplayed();
    }

    public TestRunsPage passCase() {
        firstRunTitle.shouldBe(Condition.visible, Duration.ofSeconds(5));
        firstRunTitle.click();
        firstCaseLink.click();
        passButton.click();
        return this;
    }

    public TestRunsPage failCase() {
        firstRunTitle.shouldBe(Condition.visible, Duration.ofSeconds(5));
        firstRunTitle.click();
        secondCaseLink.click();
        failButton.click();
        addResultButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        addResultButton.click();
        cancelButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        cancelButton.click();
        return this;
    }

    public boolean isPassedLabelDisplayed() {
        passedLabel.shouldBe(Condition.visible, Duration.ofSeconds(5));
        return passedLabel.isDisplayed();
    }

    public boolean isFailedLabelDisplayed() {
        failedLabel.shouldBe(Condition.visible, Duration.ofSeconds(5));
        return failedLabel.isDisplayed();
    }

}
