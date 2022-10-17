package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import constants.Urls;
import models.NewProjectModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewProjectPage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    private SelenideElement createButton = $(By.id("createButton"));
    private SelenideElement projectNameField = $(By.id("project-name"));
    private SelenideElement projectCodeField = $(By.id("project-code"));
    private SelenideElement projectDescriptionField = $(By.id("description-area"));
    private SelenideElement createProjectButton = $(By.xpath("//button//span[contains(text(), 'Create project')]"));

    public NewProjectPage openProjectPage() {
        open(Urls.PROJECTS_URL);
        return this;
    }

    public NewProjectPage fillInCreateForm(NewProjectModel projectModel) {
        String projectName = projectModel.getName();
        String projectCode = projectModel.getCode();
        String projectDescription = projectModel.getDescription();
        createButton.click();
        projectNameField.shouldBe(Condition.visible, Duration.ofSeconds(5));
        projectNameField.sendKeys(projectName);
        LOGGER.info(String.format("Project name entered - %s", projectName));
        projectCodeField.sendKeys(projectCode);
        LOGGER.info(String.format("Project code entered - %s", projectCode));
        projectDescriptionField.sendKeys(projectDescription);
        LOGGER.info(String.format("Project description entered - %s", projectDescription));
        createProjectButton.click();
        return this;
    }
}
