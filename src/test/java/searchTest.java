
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;

public class searchTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1928x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {


        open("/text-box");
        $(byCssSelector("#userName")).setValue("Kaiis");
        $(byCssSelector("#userEmail")).setValue("el@kaiis.com");
        $(byCssSelector("#currentAddress")).setValue("Italy");
        $(byCssSelector("#permanentAddress")).setValue("Spain");
        $(byCssSelector("#submit")).click();

        $("#output").$("#name").shouldHave(text("Kaiis"));
        $("#output").$("#email").shouldHave(text("el@kaiis.com"));
        $("#output").$("#currentAddress").shouldHave(text("Italy"));
        $("#output").$("#permanentAddress").shouldHave(text("Spain"));




    }
}

