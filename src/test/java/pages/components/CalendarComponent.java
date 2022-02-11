package pages.components;

import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {

    public void setDate(String day, String month, String year) {
        $x("//*[@class='react-datepicker__month-select']").selectOptionByValue(month);
        $x("//*[@class='react-datepicker__year-select']").selectOptionByValue(year);
        $x("//*[contains(@class,'react-datepicker__day--"+day+"')]").click();

    }
}