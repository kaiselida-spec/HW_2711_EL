package tests;

import com.github.javafaker.Faker;

public class TestData {
    static Faker faker = new Faker();

    static String firstName = faker.name().firstName();
    static String lastName = faker.name().lastName();
    static String userEmail = faker.internet().emailAddress();
    static String currentAddress = faker.address().fullAddress();
    static String userNumber = faker.phoneNumber().subscriberNumber(10);

}