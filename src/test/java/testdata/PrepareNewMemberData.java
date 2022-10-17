package testdata;

import com.github.javafaker.Faker;
import models.NewMemberModel;

public class PrepareNewMemberData {

    public static NewMemberModel getValidData() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String name = faker.artist().name();
        String role = faker.gameOfThrones().character();
        return NewMemberModel
                .builder()
                .email(email)
                .name(name)
                .role(role)
                .build();
    }
}
