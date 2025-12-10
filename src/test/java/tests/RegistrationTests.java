package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {
    @BeforeAll
    static void setupSelenideEnv() {
        Configuration.browserSize = "1928x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(byCssSelector("#firstName")).setValue("El");
        $(byCssSelector("#lastName")).setValue("Kaiis");
        $(byCssSelector("#userEmail")).setValue("el@kaiis.com");
        $("#genterWrapper").$(byText("Female")).click();
        $(byCssSelector("#userNumber")).setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day--003:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("test.jpeg");
        $(byCssSelector("#currentAddress")).setValue("Italy");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Noida")).click();
        $(byCssSelector("#submit")).click();

        //проверка

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("El Kaiis"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("el@kaiis.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("03 May,1998"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Biology"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("test.jpeg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Italy"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));

    }
}


