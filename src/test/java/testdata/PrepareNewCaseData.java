package testdata;

import com.github.javafaker.Faker;
import models.NewCaseModel;

public class PrepareNewCaseData {

    public static NewCaseModel getValidData() {
        Faker faker = new Faker();
        String title = faker.harryPotter().quote();
        return NewCaseModel
                .builder()
                .title(title)
                .build();
    }
}
