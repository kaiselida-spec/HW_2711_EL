package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
                .checkResult("Student Name", "El Kaiis")
                .checkResult("Student Email", "el@kaiis.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "3 May, 1998")
                .checkResult("Subjects", "Biology")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "test.jpeg")
                .checkResult("Address", "Itay")
                .checkResult("State and City", "NCR Noida");
    }

    @Test
    void successfulRegistrationWithMinimumRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName("El")
                .setLastName("Kaiis")
                .setGender("Female")
                .setUserNumber("1234567890")
                .setSubmit()
                .checkResult("Student Name", "El Kaiis")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890");
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



