package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

public class DataHelper {

    public DataHelper() {
    }

    public static AuthInfo getAuthInfoValid() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getAuthInfoNoValid() {
        Faker faker = new Faker();
        return new AuthInfo("vasya", faker.internet().password());
    }

    public static VerificationCode getVerificationCodeValid(DataHelper.VerificationCode code) {
        return new VerificationCode(code.getCode());
    }

    public static VerificationCode getVerificationCodeNoValid() {
        Faker faker = new Faker();
        return new VerificationCode(faker.number().digits(6));
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VerificationCode {
        String code;
    }
}
