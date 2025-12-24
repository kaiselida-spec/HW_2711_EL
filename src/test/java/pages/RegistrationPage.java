package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTable;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),

            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateDropdown = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityDropdown = $("#city"),
            submit = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTable resultTable = new ResultTable();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        removeBanners();
        return this; 
    }
    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBirth (String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubjects (String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies (String value){
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUploadPicture (String value){
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setStateDropdown() {
        stateDropdown.click();

        return this;
    }

    public RegistrationPage setStateCityWrapper(String value) {
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCityDropdown() {
        cityDropdown.click();

        return this;
    }
    public RegistrationPage setSubmit () {
        submit.click();
        return this;
    }
    public RegistrationPage checkResultTable( String key, String value) {
        resultTable.checkResult(key, value);
        return this;
    }

}