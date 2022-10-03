package testdata;

import com.github.javafaker.Faker;
import models.NewSuiteModel;

public class PrepareNewSuiteData {

    public static NewSuiteModel getValidData() {
        Faker faker = new Faker();
        String suiteName = faker.harryPotter().book();
        String suiteDescription = faker.harryPotter().quote();
        String suitePreconditions = faker.harryPotter().location();
        return NewSuiteModel
                .builder()
                .name(suiteName)
                .description(suiteDescription)
                .preconditions(suitePreconditions)
                .build();
    }
}
