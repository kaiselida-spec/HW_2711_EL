package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.RegistrationPage;

import java.util.stream.Stream;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeEach
    void precondition() {
        registrationPage
                .openPage();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1234567890",
            "9876543210",
            "5556667788"
    })
    @DisplayName("Успешная регистрация с разным заполнением UserNumber")
    void successfulRegistrationWithDifferentPhonesTest(String phoneNumber) {
        TestData testData = new TestData();

        registrationPage.openPage()
                    .setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setEmail(testData.email)
                    .setGender(testData.gender)
                    .setUserNumber(phoneNumber)
                    .setDateOfBirth(testData.day, testData.month, testData.year)
                    .setSubjects(testData.subjects)
                    .setHobbies(testData.hobbies)
                    .setUploadPicture(testData.picture)
                    .setCurrentAddress(testData.fullAddress)
                    .setState(testData.state)
                    .setCity(testData.city)
                    .setSubmit()
                    .checkResultTable("Student Name", testData.fullName)
                    .checkResultTable("Student Email", testData.email)
                    .checkResultTable("Gender", testData.gender)
                    .checkResultTable("Mobile", phoneNumber)
                    .checkResultTable("Date of Birth", testData.dateBirth)
                    .checkResultTable("Subjects", testData.subjects)
                    .checkResultTable("Hobbies", testData.hobbies)
                    .checkResultTable("Picture", testData.picture)
                    .checkResultTable("Address", testData.fullAddress)
                    .checkResultTable("State and City", testData.state + " " + testData.city);
//                    .closeModal();

    }



    @ParameterizedTest
    @CsvSource({
            "El, Female",
            "Jeffrey, Male"
    })
    @DisplayName("Регистрация с разными именем и полом")
    void successfulRegistrationWithDifferentNameGenderTest(String firstName,String gender){
        TestData testData = new TestData();
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(testData.lastName)
                .setGender(gender)
                .setUserNumber(testData.phoneNumber)
                .setSubmit()
                .checkResultTable("Student Name", firstName + " " + testData.lastName)
                .checkResultTable("Gender", gender)
                .checkResultTable("Mobile", testData.phoneNumber);
    }


    @ParameterizedTest(
            name = "Без PhoneNumber при firstName={0}, lastName={1}, gender={2}"
    )
    @MethodSource("registrationWithoutPhoneNumber")
    @DisplayName("Неуспешная регистрация без номера телефона")
    void registrationShouldNotSubmitWithoutPhoneNumberTest(
            String firstName,
            String lastName,
            String gender
    ) {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber("")
                .setSubmit();
    }

    static Stream<Arguments> registrationWithoutPhoneNumber() {
        return Stream.of(
                Arguments.of("El", "Kaiis", "Female"),
                Arguments.of("Megan", "Fox", "Female"),
                Arguments.of("Leo", "Dicaprio", "Male")
        );
    }
}





