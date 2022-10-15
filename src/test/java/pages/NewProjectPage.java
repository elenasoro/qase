package pages;

import com.codeborne.selenide.SelenideElement;
import constants.Urls;
import models.NewProjectModel;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewProjectPage {
    private SelenideElement projectNameField = $(By.id("project-name"));
    private SelenideElement projectCodeField = $(By.id("project-code"));
    private SelenideElement projectDescriptionField = $(By.id("description-area"));
    private SelenideElement createProjectButton = $(By.xpath("//button[contains(text(), 'Create project')]"));

    public NewProjectPage openNewProjectPage() {
        open(Urls.NEW_PROJECT_URL);
        return this;
    }

    public NewProjectPage fillInCreateForm(NewProjectModel projectModel) {
        projectNameField.sendKeys(projectModel.getName());
        projectCodeField.sendKeys(projectModel.getCode());
        projectDescriptionField.sendKeys(projectModel.getDescription());
        createProjectButton.click();
        return this;
    }

}
