package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .setFirstName("El")
                .setLastName("Kaiis")
                .setEmail("el@kaiis.com")
                .setGender("Female")
                .setUserNumber("1234567890")
                .setDateOfBirth("3", "May", "1998")
                .setSubjects("Biology")
                .setHobbies("Music")
                .setUploadPicture("test.jpeg")
                .setCurrentAddress("Italy")
                .setStateDropdown()
                .setStateCityWrapper("NCR")
                .setCityDropdown()
                .setStateCityWrapper("Noida")
                .setSubmit()
                .checkResultTable("Student Name", "El Kaiis")
                .checkResultTable("Student Email", "el@kaiis.com")
                .checkResultTable("Gender", "Female")
                .checkResultTable("Mobile", "1234567890")
                .checkResultTable("Date of Birth", "3 May,1998")
                .checkResultTable("Subjects", "Biology")
                .checkResultTable("Hobbies", "Music")
                .checkResultTable("Picture", "test.jpeg")
                .checkResultTable("Address", "Italy")
                .checkResultTable("State and City", "NCR Noida");

    }

    @Test
    void successfulRegistrationWithMinimumRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName("El")
                .setLastName("Kaiis")
                .setGender("Female")
                .setSubmit()
                .checkResultTable("Student Name", "El Kaiis")
                .checkResultTable("Gender", "Female")
                .checkResultTable("Mobile", "1234567890");
    }

    @Test
    void registrationShouldNotSubmitWithoutPhoneNumberTest() {
        registrationPage.openPage()
                .setFirstName("El")
                .setLastName("Kaiis")
                .setGender("Female")
                .setSubmit();
    }
}



