package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import constants.Urls;
import models.NewProjectModel;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewProjectPage {
    private SelenideElement createButton = $(By.id("createButton"));
    private SelenideElement projectNameField = $(By.id("project-name"));
    private SelenideElement projectCodeField = $(By.id("project-code"));
    private SelenideElement projectDescriptionField = $(By.id("description-area"));
    private SelenideElement createProjectButton = $(By.xpath("//button[contains(text(), 'Create project')]"));

    public NewProjectPage openProjectPage() {
        open(Urls.PROJECTS_URL);
        return this;
    }

    public NewProjectPage fillInCreateForm(NewProjectModel projectModel) {
        createButton.click();
        projectNameField.shouldBe(Condition.visible, Duration.ofSeconds(5));
        projectNameField.sendKeys(projectModel.getName());
        projectCodeField.sendKeys(projectModel.getCode());
        projectDescriptionField.sendKeys(projectModel.getDescription());
        createProjectButton.click();
        return this;
    }

}
