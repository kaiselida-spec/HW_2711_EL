package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    @Test
    void successfulRegistrationTest() {

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = RandomUtils.randomGender();
        String phoneNumber = faker.number().digits(10);
        String day = "3";
        String month = "May";
        String year = "1998";
        String subject = RandomUtils.randomSubject();
        String hobby = RandomUtils.randomHobby();
        String picture = "test.jpeg";
        String address = faker.address().fullAddress();
        String state = RandomUtils.randomState();
        String city = RandomUtils.randomCityForState(state);


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateOfBirth(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobby)
                .setUploadPicture(picture)
                .setCurrentAddress(address)
                .setStateDropdown()
                .setStateCityWrapper(state)
                .setCityDropdown()
                .setStateCityWrapper(city)
                .setSubmit()


                .checkResultTable("Student Name", firstName + " " + lastName)
                .checkResultTable("Student Email", email)
                .checkResultTable("Gender", gender)
                .checkResultTable("Mobile", phoneNumber)
                .checkResultTable("Date of Birth", day + " " + month + "," + year)
                .checkResultTable("Subjects", subject)
                .checkResultTable("Hobbies", hobby)
                .checkResultTable("Picture", picture)
                .checkResultTable("Address", address)
                .checkResultTable("State and City", state + " " + city);
    }
}