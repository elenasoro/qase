package testdata;

import com.github.javafaker.Faker;
import models.NewProjectModel;

public class PrepareNewProjectData {

    public static NewProjectModel getValidData() {
        Faker faker = new Faker();
        String projectName = faker.company().name();
        String projectCode = projectName.substring(0,2).toUpperCase();
        String projectDescription = faker.harryPotter().quote();
        return NewProjectModel
                .builder()
                .name(projectName)
                .code(projectCode)
                .description(projectDescription)
                .build();
    }
}
