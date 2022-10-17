package testdata;

import com.github.javafaker.Faker;
import models.NewDefectModel;

public class PrepareNewDefectData {

    public static NewDefectModel getValidData() {
        Faker faker = new Faker();
        String title = faker.harryPotter().book();
        String actualResult = faker.harryPotter().quote();
        return NewDefectModel
                .builder()
                .title(title)
                .actualResult(actualResult)
                .build();
    }
}
