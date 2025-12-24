package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static tests.TestData.*;

public class RegistrationWithTestDataTests  extends TestBase {
   // String firstName = "El";
   // String lastName = "Kaiis";
   // String userEmail = "el@kaiis.com";
   // String userNumber = "1234567890";

    @Test
    void successfulRegistrationTest() {
      //  String firstName = "El";
        // String lastName = "Kaiis";
        //String userEmail = "el@kaiis.com";
        //String userNumber = "1234567890";





        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(byCssSelector("#firstName")).setValue(firstName);
        $(byCssSelector("#lastName")).setValue(lastName);
        $(byCssSelector("#userEmail")).setValue(userEmail);
        $("#genterWrapper").$(byText("Female")).click();
        $(byCssSelector("#userNumber")).setValue(userNumber);
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

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(byCssSelector(".table-responsive")).shouldHave(
                text(firstName),
                text(lastName),
                text(userEmail)
        );
    }
}
