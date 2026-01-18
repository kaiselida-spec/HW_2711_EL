package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final SelenideElement
            monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year) {
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);


        String dayWithZero = day.length() == 1 ? "0" + day : day;


        String dayLocator = String.format(
                ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)",
                dayWithZero
        );

        $(dayLocator).click();
    }
}