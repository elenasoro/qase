package testdata;

import models.LoginModel;

public class PrepareLoginData {

    public static LoginModel getValidData() {
        return LoginModel
                .builder()
                .email(System.getProperty("email"))
                .password(System.getProperty("password"))
                .build();
    }

}
