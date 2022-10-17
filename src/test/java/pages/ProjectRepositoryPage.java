package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import models.NewCaseModel;
import models.NewSuiteModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class ProjectRepositoryPage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    private SelenideElement createSuiteButton = $(By.id("create-suite-button"));
    private SelenideElement createSuiteFormTitle = $(By.xpath("//form//h2[contains(text(), 'Create suite')]"));
    private SelenideElement suiteNameInput = $(By.id("name"));
    private SelenideElement descriptionInput = $(By.xpath("//div[@id='descriptionGroup']//p"));
    private SelenideElement preconditionsInput = $(By.xpath("//div[@id='preconditionsGroup']//p"));
    private SelenideElement saveSuiteButton = $(By.id("save-suite-button"));
    private SelenideElement createCaseButton = $(By.id("create-case-button"));
    private SelenideElement titleInput = $(By.id("title"));
    private SelenideElement saveCaseButton = $(By.id("save-case"));
    private SelenideElement successSuiteNotification = $(By.xpath("//span[contains(text(), 'Suite was successfully created.')]"));
    private SelenideElement successCaseNotification = $(By.xpath("//span[contains(text(), 'Test case was created successfully!')]"));
    private SelenideElement testRunsLink = $(By.xpath("//a[@title='Test Runs']"));
    private SelenideElement defectsLink = $(By.xpath("//a[@title='Defects']"));

    public ProjectRepositoryPage openCreateSuiteForm() {
        createSuiteButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        createSuiteButton.click();
        return this;
    }

    public ProjectRepositoryPage openCreateCasePage() {
        createCaseButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        createCaseButton.click();
        return this;
    }

    public TestRunsPage openTestRunsPage() {
        testRunsLink.shouldBe(Condition.visible, Duration.ofSeconds(5));
        testRunsLink.click();
        return new TestRunsPage();
    }

    public DefectsPage openDefectsPage() {
        defectsLink.shouldBe(Condition.visible, Duration.ofSeconds(5));
        defectsLink.click();
        return new DefectsPage();
    }

    public ProjectRepositoryPage fillInCreateSuiteForm(NewSuiteModel suiteModel) {
        createSuiteFormTitle.shouldBe(Condition.visible, Duration.ofSeconds(5));
        suiteNameInput.sendKeys(suiteModel.getName());
        descriptionInput.sendKeys(suiteModel.getDescription());
        preconditionsInput.sendKeys(suiteModel.getPreconditions());
        saveSuiteButton.click();
        return this;
    }

    public ProjectRepositoryPage fillInCreateCaseForm(NewCaseModel caseModel) {
        String caseTitle = caseModel.getTitle();
        titleInput.shouldBe(Condition.visible, Duration.ofSeconds(5));
        titleInput.sendKeys(caseTitle);
        LOGGER.info(String.format("Case title entered - %s", caseTitle));
        saveCaseButton.click();
        return this;
    }

    public boolean isSuiteNotificationDisplayed() {
        successSuiteNotification.shouldBe(Condition.visible, Duration.ofSeconds(5));
        return successSuiteNotification.isDisplayed();
    }

    public boolean isCaseNotificationDisplayed() {
        successCaseNotification.shouldBe(Condition.visible, Duration.ofSeconds(5));
        return successCaseNotification.isDisplayed();
    }
}
