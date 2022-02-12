package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {

    String dayPickerXPath = "//*[contains(@class,'react-datepicker__day--";

    private final SelenideElement
            monthPicker = $x("//*[@class='react-datepicker__month-select']"),
            yearPicker = $x("//*[@class='react-datepicker__year-select']");
    private SelenideElement dayPicker;

    public void denifeXPathForDayPicker(String day){
           dayPicker = $x("//*[contains(@class,'react-datepicker__day--" + day + "')]");
    }

    public void setDate(String day, String month, String year) {
        denifeXPathForDayPicker(day);
        monthPicker.selectOptionByValue(month);
        yearPicker.selectOptionByValue(year);
        dayPicker.click();
    }
}