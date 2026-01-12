package utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    private static final Faker faker = new Faker();

    public static String firstName() {
        return faker.name().firstName();
    }

    public static String lastName() {
        return faker.name().lastName();
    }

    public static String email() {
        return faker.internet().emailAddress();
    }

    public static String phoneNumber() {
        return faker.number().digits(10);
    }

    public static String address() {
        return faker.address().fullAddress();
    }
}