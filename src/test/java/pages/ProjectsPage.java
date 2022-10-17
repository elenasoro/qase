package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import constants.Urls;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    private SelenideElement createProjectButton = $(By.id("createButton"));
    private SelenideElement projectsTable = $(By.xpath("//table[contains(@class, 'projects-table')]"));
    private ElementsCollection projectsList = $$(By.xpath("//table[contains(@class, 'projects-table')]//a[contains(@class, 'defect-title')]"));
    private SelenideElement firstProjectLink = $(By.xpath("//table[contains(@class, 'projects-table')]//a[contains(@class, 'defect-title')][1]"));

    public ProjectsPage openProjectsPage() {
        open(Urls.PROJECTS_URL);
        return this;
    }

    public boolean isCreateButtonDisplayed() {
        createProjectButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        return createProjectButton.isDisplayed();
    }

    public boolean isCreatedProjectPresent(String companyName) {
        projectsTable.shouldBe(Condition.visible, Duration.ofSeconds(5));
        boolean result = false;
        for(SelenideElement element : projectsList){
            if (element.getText().equals(companyName)){
                result = true;
                LOGGER.info(String.format("Project %s is found", companyName));
                break;
            }
        }
        return result;
    }

    public ProjectsPage openFirstProjectRepo() {
        firstProjectLink.shouldBe(Condition.visible, Duration.ofSeconds(5));
        firstProjectLink.click();
        return this;
    }
}
