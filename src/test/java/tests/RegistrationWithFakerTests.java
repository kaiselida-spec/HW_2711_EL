package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.data.RegistrationTestData;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        RegistrationTestData data = new RegistrationTestData();
        int dayInt = Integer.parseInt(data.day);

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setUserNumber(data.phoneNumber)
                .setDateOfBirth(dayInt, data.month, data.year)
                .setSubjects(data.subject)
                .setHobbies(data.hobby)
                .setUploadPicture(data.picture)
                .setCurrentAddress(data.address)
                .setStateDropdown()
                .setStateCityWrapper(data.state)
                .setCityDropdown()
                .setStateCityWrapper(data.city)
                .setSubmit()

                .checkResultTable("Student Name", data.firstName + " " + data.lastName)
                .checkResultTable("Student Email", data.email)
                .checkResultTable("Gender", data.gender)
                .checkResultTable("Mobile", data.phoneNumber)
                .checkResultTable("Date of Birth", data.day + " " + data.month + "," + data.year)
                .checkResultTable("Subjects", data.subject)
                .checkResultTable("Hobbies", data.hobby)
                .checkResultTable("Picture", data.picture)
                .checkResultTable("Address", data.address)
                .checkResultTable("State and City", data.state + " " + data.city);
    }
}